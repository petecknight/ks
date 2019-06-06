#!/bin/bash

docker-compose up -d

sleep 20


docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic UserClicks --partitions 1 --replication-factor 1'

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic AnomalousUsers --partitions 1 --replication-factor 1'
