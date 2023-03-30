# Use https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:18

# Make a directory
RUN mkdir -p /app
WORKDIR /app

# Copy only the target jar over
COPY target/uberjar/helloworld-standalone.jar .

# Open the ports
EXPOSE 3000

# Run the JAR
CMD ["java", "-jar", "helloworld-standalone.jar"]
