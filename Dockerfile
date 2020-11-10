FROM openjdk:8u191-jdk-alpine3.9
ADD target/engcard-backend-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar engcard-backend-0.0.1-SNAPSHOT.jar

