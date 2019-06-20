**JsonToAvroExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`JsonToAvroExample.sh`

This converts JSON input data to Avro format - use the JsonToAvroExampleDriver to produce and consume the data