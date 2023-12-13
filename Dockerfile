FROM openjdk:17-ea-3-jdk-oracle
EXPOSE 8090
ADD target/employee-service.war /employee-service.war
ENTRYPOINT ["java", "-jar", "/employee-service.war"]