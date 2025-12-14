FROM eclipse-temurin:21.0.2_13-jre-alpine

LABEL org.opencontainers.image.source=https://github.com/Panopticode-KronosCloud/ms-ingest
LABEL org.opencontainers.image.description="Kronos Ingest microservice"
LABEL org.opencontainers.image.licenses=GPL-3.0-or-later

WORKDIR /app
COPY build/libs/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]