FROM openjdk:21
COPY ./target/Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
COPY run.sh ./
WORKDIR ./
RUN chmod +x run.sh
CMD ["./run.sh"]