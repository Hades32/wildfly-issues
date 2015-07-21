#!/bin/bash

docker run -it --rm --name my-maven-project -v $PWD:/usr/src/mymaven -v /root/.m2:/root/.m2 -w /usr/src/mymaven maven:3.3-jdk-8 mvn clean install
