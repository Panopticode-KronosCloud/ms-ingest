FROM eclipse-temurin:21.0.2_13-jre-alpine

WORKDIR /app
COPY build/libs/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]