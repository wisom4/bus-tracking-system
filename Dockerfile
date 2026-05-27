FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY . .

WORKDIR /app/bus-backend

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/bus-backend/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]