#!/bin/bash

docker run -it --network="host" --rm -p 3000:3000 grafana/grafana