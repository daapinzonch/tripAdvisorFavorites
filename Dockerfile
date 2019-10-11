FROM openjdk:8-jdk-alpine

ARG JAR=web.jar
COPY target/$JAR /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
