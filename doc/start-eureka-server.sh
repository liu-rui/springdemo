#!/usr/bin/env bash

nohup java -jar ../springdemo-eurekaserver/target/springdemo-eurekaserver-1.0-SNAPSHOT.jar --spring.profiles.active=8081 > eurekaserver8081.log &
nohup java -jar ../springdemo-eurekaserver/target/springdemo-eurekaserver-1.0-SNAPSHOT.jar --spring.profiles.active=8082 > eurekaserver8082.log &