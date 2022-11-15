FROM openjdk:11
EXPOSE 8089
ADD target/DevOps.jar DevOps.jar
ENTRYPOINT ["java", "-jar", "/DevOps.jar"]