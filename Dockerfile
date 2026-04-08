FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

CMD ["java","-jar","target/SDP_07_ElectionMonitoringSystem-0.0.1-SNAPSHOT.jar"]
