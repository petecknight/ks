* generateAvro

* copyTask

* build

`kafka-console-consumer --topic AnomalousUsers --from-beginning \
--bootstrap-server localhost:9092 \
--property print.key=true \
--property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer`

`kafka-console-producer --broker-list localhost:9092 --topic UserClicks`