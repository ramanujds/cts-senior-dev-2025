FROM maven:3.9.9-amazoncorretto-21-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

EXPOSE 8080

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]