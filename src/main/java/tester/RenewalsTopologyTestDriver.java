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

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

public class RenewalsTopologyTestDriver {

    public static void main(final String[] args) {
        final String bootstrapServers = args.length > 0 ? args[0] : "localhost:29092";
        final String schemaRegistryUrl = args.length > 1 ? args[1] : "http://localhost:8081";
        produceInputs(bootstrapServers, schemaRegistryUrl);
        consumeOutput(bootstrapServers, schemaRegistryUrl);
    }

    private static void produceInputs(final String bootstrapServers, final String schemaRegistryUrl) {

        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);

        // set up the ppt threads and run
        Arrays.asList(
                pptProducer(props, 4, "trigger-gb"),
                pptProducer(props, 3, "trigger-ie"),
                pptProducer(props, 3, "trigger-at"),
                pptProducer(props, 3, "trigger-es"),
                pptProducer(props, 5, "trigger-us"))
                .forEach(pptRunnable -> new Thread(pptRunnable).start());
    }

    // runnable holding the producer configuration and delay for each message
    private static Runnable pptProducer(Properties props, int i, String s) {
        return () ->
        {
            final KafkaProducer<String, String> producer = new KafkaProducer<>(props);

            IntStream.range(0, 5100)
                    .forEach(
                            bucketNumber -> {
                                try {
                                    Thread.sleep(i);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                producer.send(new ProducerRecord<>(s, null, s.concat(String.valueOf(bucketNumber))));
                            });
        };
    }

    private static void consumeOutput(final String bootstrapServers, final String schemaRegistryUrl) {

        final Properties consumerProperties = new Properties();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerProperties.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);

        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "tester-consumer11");
        consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProperties,
                new StringDeserializer(),
                new StringDeserializer());

        consumer.subscribe(Collections.singletonList("batch-complete"));

        while (true) {
            final ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(Long.MAX_VALUE));
            for (final ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("RSC received completion notification ::: " + consumerRecord.value());
            }
        }
    }


}
