**WordCountExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`WordCountExample.sh`

To get onto the broker to run commands directly:

`docker-compose exec broker bash`

Otherwise, to get the producer to add messages to the source topic for this project:

`docker-compose exec broker bash -c 'kafka-console-producer --broker-list localhost:9092 --topic streams-plaintext-input'`

And to consume messages from the output topic:

`docker-compose exec broker bash -c 'kafka-console-consumer --topic streams-wordcount-output 
--from-beginning --bootstrap-server localhost:9092 --property print.key=true 
--property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer'`

