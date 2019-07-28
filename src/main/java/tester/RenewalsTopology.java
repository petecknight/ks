/*
 * Copyright Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tester;

import jdk.internal.joptsimple.util.KeyValuePair;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class RenewalsTopology {

    public static void main(final String[] args) {

        final Serde<String> stringSerde = Serdes.String();
        final StreamsBuilder builder = new StreamsBuilder();

        final List<KStream<String, String>> pptList = registerStreams(stringSerde, builder);

        // build topology
        pptList.forEach(ppt -> ppt.mapValues(RenewalsTopology::databaseCall)
                .mapValues(RenewalsTopology::subscriptionRestCall)
                .to("bucket-complete"));

        // consume bucket completions
        final KStream<String, String> bucketCompletions = builder.stream("bucket-complete", Consumed.with(stringSerde, stringSerde));
        bucketCompletions
                .filter(isBatchComplete)
                .mapValues((key, value) -> value + " completed @ " + LocalDateTime.now())
                .to("batch-complete");

        // kick off the stream
        final KafkaStreams streams = new KafkaStreams(builder.build(), initBroker(args));

        streams.cleanUp();
        streams.start();
        streams.state();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    /**
     * check batch status against the database - true if batch is completed and no more buckets remain
     */
    private static Predicate<String, String> isBatchComplete = (key, value) -> value.endsWith("5099-done");

    /**
     * make database call to get subscriptions for this trigger
     */
    private static List<String> databaseCall(String readOnlyKey, String value) {
        System.out.println("Database call for: " + value);
        return Collections.singletonList(value);
    }

    /**
     * make REST call to renew to subscription
     */
    private static String subscriptionRestCall(String key, List<String> value) {
        System.out.println("Subscribe rest call for: " + value.get(0));
        return value.get(0) + "-done";
    }

    // setup configuration
    private static Properties initBroker(String[] args) {
        final String bootstrapServers = args.length > 0 ? args[0] : "localhost:29092";
        final Properties streamsConfiguration = new Properties();

        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "tester11");
        streamsConfiguration.put(StreamsConfig.CLIENT_ID_CONFIG, "tester-client11");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.ByteArray().getClass().getName());
        streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        return streamsConfiguration;
    }

    // build topology for ppts
    private static List<KStream<String, String>> registerStreams(Serde<String> stringSerde, StreamsBuilder builder) {

        final KStream<String, String> triggerGB = builder.stream("trigger-gb", Consumed.with(stringSerde, stringSerde));
        final KStream<String, String> triggerAT = builder.stream("trigger-at", Consumed.with(stringSerde, stringSerde));
        final KStream<String, String> triggerIE = builder.stream("trigger-ie", Consumed.with(stringSerde, stringSerde));
        final KStream<String, String> triggerES = builder.stream("trigger-es", Consumed.with(stringSerde, stringSerde));
        final KStream<String, String> triggerUS = builder.stream("trigger-us", Consumed.with(stringSerde, stringSerde));

        return Arrays.asList(triggerGB, triggerAT, triggerIE, triggerES, triggerUS);
    }

}
