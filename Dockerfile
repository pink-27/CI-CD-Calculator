FROM openjdk:21
COPY ./target/Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
ENTRYPOINT ["java", "-cp","Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar","org.example.Main"]