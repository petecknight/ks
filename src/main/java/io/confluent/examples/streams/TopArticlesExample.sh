#!/usr/bin/env bash

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic PageViews --partitions 1 --replication-factor 1'

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --create --topic TopNewsPerIndustry --partitions 1 --replication-factor 1'
