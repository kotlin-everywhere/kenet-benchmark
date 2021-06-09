#!/bin/sh -e

trap 'jobs -p | xargs -r kill -9' EXIT

TZ=Asia/Seoul date >> result.txt
echo "" >> result.txt

./benchmark-2-memory-usage/build/install/benchmark-2-memory-usage/bin/benchmark-2-memory-usage &
sleep 0.1
./quit/build/install/quit/bin/quit
