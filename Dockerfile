# alpine images are generally very small in size
FROM maven:3.6.1-jdk-8-alpine as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests=true

FROM gcr.io/distroless/java:8
WORKDIR /app
COPY --from=builder /app/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]