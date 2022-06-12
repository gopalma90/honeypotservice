FROM openjdk:19-ea-25-oraclelinux8
COPY ./target/honeypotService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]