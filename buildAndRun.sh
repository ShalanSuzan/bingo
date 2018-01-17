#!/usr/bin/env bash

#build the docker container with the project name tag.
sudo docker build . -t="pingo"
sudo docker run -t pingo:latest


