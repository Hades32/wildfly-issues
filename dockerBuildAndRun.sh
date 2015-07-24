#!/bin/sh
docker build -t wf-issues . && docker run -it -p 8080:8080 wf-issues

