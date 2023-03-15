FROM openjdk:17-oracle
WORKDIR /
COPY target/echo-0.0.1-SNAPSHOT.jar echo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar echo-0.0.1-SNAPSHOT.jar