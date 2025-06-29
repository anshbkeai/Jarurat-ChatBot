# Use OpenJDK 21 with Alpine Linux as base image
FROM openjdk:21-jdk-alpine

# Set working directory
WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy Maven files first for better layer caching
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .
COPY mvnw.cmd .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src/ src/

# Build the application
RUN ./mvnw clean package -DskipTests

# Create a new stage for runtime to reduce image size
FROM openjdk:21-jre-alpine

# Set working directory
WORKDIR /app

# Install curl for health checks (optional)
RUN apk add --no-cache curl

# Copy the built jar from the previous stage
COPY --from=0 /app/target/*.war app.war

# Create a non-root user for security
RUN addgroup -g 1001 -S spring && \
    adduser -S spring -u 1001 -G spring

# Change ownership of the app directory
RUN chown -R spring:spring /app

# Switch to non-root user
USER spring

# Expose port 8080
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.war"]

# Optional: Add JVM tuning for containerized environments
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:MaxGCPauseMillis=200"
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.war"]
