#!/usr/bin/env bash

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic WikipediaFeed --partitions 1 --replication-factor 1'

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic WikipediaStats --partitions 1 --replication-factor 1'
