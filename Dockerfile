FROM adoptopenjdk/openjdk16:ubi

ARG JAR_FILE=target/Odontologica-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080

