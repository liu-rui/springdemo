#!/usr/bin/env bash

nohup java -jar ../springdemo-userwebapi/target/springdemo-userwebapi-1.0-SNAPSHOT.jar --spring.profiles.active=8091 > user8091.log &
nohup java -jar ../springdemo-userwebapi/target/springdemo-userwebapi-1.0-SNAPSHOT.jar --spring.profiles.active=8092 > user8092.log &