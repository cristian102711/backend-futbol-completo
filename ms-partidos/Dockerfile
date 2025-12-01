# --- ETAPA 1: COCINAR (Construir el JAR usando Maven) ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# --- ETAPA 2: SERVIR (Ejecutar lo que cocinamos) ---
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]