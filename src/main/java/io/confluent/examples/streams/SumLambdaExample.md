**SumLambdaExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`SumLambdaExample.sh`

write some data to the input topic using the SumLambdaExampleDriver

And to consume messages from the output topic:

`docker-compose exec broker bash -c 'kafka-console-consumer --topic sum-of-odd-numbers-topic  
--from-beginning --bootstrap-server localhost:9092'`




