#!/bin/bash

docker exec broker bash -c 'cd /etc/kafka; kafka-topics --zookeeper zookeeper:2181 --delete --topic sky.csc.stubbed.tds.title.json; kafka-topics --zookeeper zookeeper:2181 --delete --topic sky.csc.stubbed.rights.availability-window.processed; kafka-topics --zookeeper zookeeper:2181 --delete --topic sky.csc.stubbed.tds.bsstitle.json; kafka-topics --zookeeper zookeeper:2181 --delete --topic sky.csc.stubbed.tds.rekeyedtas.json'

docker-compose down