FROM openjdk:17
ARG JAR_FILE=target/*.jar
EXPOSE 8000
COPY ${JAR_FILE} enoca-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/enoca-0.0.1-SNAPSHOT.jar"]