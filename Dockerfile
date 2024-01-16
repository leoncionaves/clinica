FROM openjdk:17-jdk-alpine
RUN mkdir /app
COPY target/*.jar /app/app.jar
COPY src/main/resources/application-homolog.yml /app/application.yml
ENTRYPOINT ["java", "-jar", "/app/app.jar"]