FROM openjdk:11
EXPOSE 8089
ADD target/achat-1.0-SNAPSHOT.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar"]