**PageViewRegionExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`PageViewRegionExample.sh`


write some data to the input topic using the PageViewRegionExampleDriver

And to consume messages from the output topic:

`docker-compose exec broker bash -c 'kafka-console-consumer --topic PageViewsByRegion  
--from-beginning --bootstrap-server localhost:9092'`




