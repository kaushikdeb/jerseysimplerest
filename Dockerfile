FROM anapsix/alpine-java

COPY target/jerseysimplerest-0.0.1-SNAPSHOT-jar-with-dependencies.jar /
WORKDIR /

CMD ["java", "-jar", "/jerseysimplerest-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]