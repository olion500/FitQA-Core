FROM openjdk:11-jdk
ARG JAR_FILE=./spring/fitqa-spring-java/build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]