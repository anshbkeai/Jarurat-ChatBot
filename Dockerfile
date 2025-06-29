# ---- Build Stage ----
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

RUN apt-get update && apt-get install -y maven
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .
COPY mvnw.cmd .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# ---- Runtime Stage ----
FROM eclipse-temurin:21-jdk
WORKDIR /app
RUN apt-get update && apt-get install -y curl

COPY --from=builder /app/target/jarurat-chatbot-0.0.1-SNAPSHOT.war app.war

RUN addgroup --gid 1001 spring && \
    adduser --uid 1001 --gid 1001 --disabled-password spring && \
    chown -R spring:spring /app
USER spring

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:MaxGCPauseMillis=200"
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.war"]
