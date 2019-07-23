#!/usr/bin/env bash

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic trigger-gb'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic trigger-at'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic trigger-ie'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic trigger-es'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic trigger-us'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic batch-complete'
docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic bucket-complete'

