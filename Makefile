.PHONY: build clean run

build: tema1

run:
	java -Xmx1G -cp ./bin Main ${ARGS}

tema1:
	javac -d ./bin ./src/*.java ./src/*/*.java

clean:
	rm -rf ./bin
	rm -f log.txt fisier
