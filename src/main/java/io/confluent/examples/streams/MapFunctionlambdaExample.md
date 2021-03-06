**MapFunctionlambdaExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`MapFunctionlambdaExample.sh`

This example shows when you need to explicitly define serdes and when they are implied

Produce some lowercase text to the input topic 

`docker-compose exec broker bash -c 'kafka-console-producer --broker-list localhost:9092 --topic TextLinesTopic'`

And to consume messages from the output topic:

`docker-compose exec broker bash -c 'kafka-console-consumer --topic UppercasedTextLinesTopic  
--from-beginning --bootstrap-server localhost:9092'`

`docker-compose exec broker bash -c 'kafka-console-consumer --topic OriginalAndUppercasedTopic  
--from-beginning --bootstrap-server localhost:9092 --property print.key=true'`