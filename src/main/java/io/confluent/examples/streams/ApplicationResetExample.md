**ApplicationResetExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`ApplicationResetExample.sh`

To get onto the broker to run commands directly:

`docker-compose exec broker bash`

Otherwise, to get the producer to add messages to the source topic for this project:

`docker-compose exec broker bash -c 'kafka-console-producer --broker-list localhost:9092 --topic my-input-topic'`

And to consume messages from the output topic:

`docker-compose exec broker bash -c 'kafka-console-consumer --topic my-output-topic  
--from-beginning --bootstrap-server localhost:9092 --property print.key=true 
--property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer'`

Now stop the application and reset the offsets

`docker-compose exec broker bash -c 'kafka-streams-application-reset --application-id 
application-reset-demo --input-topics my-input-topic --intermediate-topics rekeyed-topic'`

