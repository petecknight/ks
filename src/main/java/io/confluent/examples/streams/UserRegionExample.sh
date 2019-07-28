#!/usr/bin/env bash

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic UserRegions --partitions 1 --replication-factor 1'

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic LargeRegions --partitions 1 --replication-factor 1'
