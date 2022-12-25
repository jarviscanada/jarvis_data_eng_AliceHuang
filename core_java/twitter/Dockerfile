FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} java_apps-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java_apps-1.0-SNAPSHOT.jar"]
