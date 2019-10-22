FROM anapsix/alpine-java

COPY target/jerseysimplerest-jar-with-dependencies.jar /
WORKDIR /

CMD ["java", "-jar", "/jerseysimplerest-jar-with-dependencies.jar"]