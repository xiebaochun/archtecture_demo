FROM openjdk:8
ADD target/jwt-auth-service-1.0.0.jar jwt-auth-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "jwt-auth-service.jar"]