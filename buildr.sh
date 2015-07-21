#!/bin/bash

docker run --rm -ti -v `pwd`:/workspace -v $HOME/.buildr:/root/.buildr -v $HOME/.m2:/root/.m2 vanto/apache-buildr:latest-jruby-jdk8 clean package

