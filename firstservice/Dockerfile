# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file and its dependencies
COPY build/libs/firstservice-0.0.1-SNAPSHOT-plain.jar /app

# Set entrypoint
ENTRYPOINT ["java", "-jar", "/app/firstservice-0.0.1-SNAPSHOT-plain.jar"]