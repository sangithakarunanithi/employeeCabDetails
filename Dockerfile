# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your machine to the container
COPY target/employeeCabDetails-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port on which the Spring Boot app runs
EXPOSE 9822

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
