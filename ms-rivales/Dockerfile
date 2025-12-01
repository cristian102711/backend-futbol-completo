# Usamos una imagen de Java 21 liviana (Alpine)
FROM eclipse-temurin:21-jdk-alpine

# Carpeta temporal
VOLUME /tmp

# Copiamos el archivo compilado (.jar) y lo renombramos a app.jar
COPY target/*.jar app.jar

# Comando para iniciar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]