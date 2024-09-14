FROM openjdk:17
ADD target/ItemConsume.jar ItemConsume.jar
ENTRYPOINT ["java", "-jar", "/ItemConsume.jar"]