#!/usr/bin/env bash

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-gb --partitions 16 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-at --partitions 16 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-ie --partitions 16 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-es --partitions 16 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic trigger-us --partitions 16 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic batch-complete --partitions 16 --replication-factor 1'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic bucket-complete --partitions 16 --replication-factor 1'
