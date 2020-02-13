# Start with a base image containing Java runtime
FROM openjdk:11-jdk-slim

# Add Maintainer Info
LABEL maintainer="maicocamargo08@hotmail.com"

# Add a volume pointing to /tmp
VOLUME /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
COPY target/desafio-ilegra-*.war /app.war

# specify default command
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/desafio-ilegra.war"]

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/desafio-ilegra.jar"]