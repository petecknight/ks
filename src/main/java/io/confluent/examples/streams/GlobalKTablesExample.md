**GlobalKTablesExample**

Go to root of project and bring up Kafka by running docker-compose up:

```
  docker rm -f $(docker ps -aq)
  docker-compose up -d
 ```

Execute script to add the required topics

`GlobalKTablesExample.sh`

To produce data to the input topics run GlobalKTablesExampleDriver which will stimulate the topology. 
It will then consume and output the results from the outbound topic to the console.

This example shows that GlobalKTables are not required to be co-partitioned as a copy of each ingested
dataset is distributed across the Kafa Streams application. This is ideal for lookup data but not if the
amount of data is going to be large due to the replication (basically a copy and paste job)

In this example, the main "load" of orders is read as a stream and joined on key with the "lookup" 
data from GlobalKTables (customer and product)
