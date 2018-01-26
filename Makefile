all: run

install-gui:
	mvn validate

build:
	mvn validate
	mvn -Dmaven.test.skip=true clean install

run: build
	mvn -f pom.xml spring-boot:run

clean:
	mvn -Dmaven.test.skip=true clean
