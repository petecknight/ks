#!/usr/bin/env bash

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-gb --partitions 1 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-at --partitions 1 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-ie --partitions 1 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-es --partitions 1 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-us --partitions 1 --replication-factor 1'


