**SessionWindowsExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`SessionWindowsExample.sh`

write some data to the input topic using the SessionWindowsExampleDriver which will also consume and print the output




