FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 2005

ENTRYPOINT ["java","-jar","app.jar"]
