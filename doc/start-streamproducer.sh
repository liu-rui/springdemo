#!/usr/bin/env bash

java -jar springdemo-streamconsumer/target/springdemo-streamconsumer-1.0-SNAPSHOT.jar \
--spring.profiles.active=partition \
--server.port=8612 \
--spring.cloud.stream.bindings.input.consumer.instanceIndex=1

