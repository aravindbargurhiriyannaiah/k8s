FROM adoptopenjdk/openjdk11:latest
COPY build/libs/arjuna-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9080
