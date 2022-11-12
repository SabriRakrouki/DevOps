FROM maven:3.8.2-jdk-8
COPY  target/achat-1.0.jar achat-1.0.jar
EXPOSE 8089

ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]