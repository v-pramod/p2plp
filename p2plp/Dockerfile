# Use a base image with Java 11 installed
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/p2plp-0.0.1-SNAPSHOT.jar p2plp-0.0.1-SNAPSHOT.jar

# Expose the port that the application listens on
EXPOSE 8080

# Set the command to run the application when the container starts
CMD ["java", "-jar", "p2plp-0.0.1-SNAPSHOT.jar"]