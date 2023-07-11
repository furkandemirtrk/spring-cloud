# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file and its dependencies
COPY build/libs/springcloudgateway-0.0.1-SNAPSHOT.jar /app

# Set entrypoint
ENTRYPOINT ["java", "-jar", "/app/springcloudgateway-0.0.1-SNAPSHOT.jar"]