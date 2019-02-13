#!/bin/bash

TIMEOUT=20s

make clean
make build

no_tests=98

rm -rf ./tests/ref
mkdir ./tests/ref
rm -rf log.txt
touch fisier

grade=0
for i in {0..98}; do
	timeout $TIMEOUT make run ARGS="./tests/input/Test$i.in ./tests/ref/Test$i.out"
	java -jar checker.jar "./tests/input/Test$i.in" "./tests/ref/Test$i.out" >> log.txt
done

echo "Teste picate:"
grep 'false' fisier

echo "Total: $(grep 'true' log.txt | wc -l) / 99"

echo "Log:"
cat log.txt

echo "Total: $(grep 'true' log.txt | wc -l) / 99"

make clean
