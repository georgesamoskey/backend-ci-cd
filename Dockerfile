# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11-slim AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the containers
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official OpenJDK image as the base 
FROM openjdk:11-jre-slim
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
# COPY - from=build /payall/target/*.jar  app.jar
COPY --from=build /payall/app/target/*.jar app.jar

# Set the command to run the application
CMD ["java", "-jar", "app.jar"]