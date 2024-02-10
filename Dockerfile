# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-17 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the containers
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn -f clean package -DskipTests
# Use an official OpenJDK image as the base 
FROM openjdk:17
# Set the working directory in the container
WORKDIR /payall
# Copy the built JAR file from the previous stage to the container
# COPY - from=build /payall/target/*.jar  app.jar
COPY --from=build /payall/target/*.jar app.jar

# Set the command to run the application
CMD ["java", "-jar", "app.jar"]

# Build stage latest version---
# FROM maven:3.6.3-jdk-8-slim AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean test package

# Package stage
# FROM openjdk:8-jdk-alpine
# COPY --from=build /home/app/target/*.jar app.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","app.jar"]