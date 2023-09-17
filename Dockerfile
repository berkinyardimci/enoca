FROM openjdk:17
EXPOSE 8000
COPY /target/enoca-0.0.1-SNAPSHOT.jar app.jar
CMD [ "java", "-jar", "app.jar" ]
