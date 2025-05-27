FROM maven:3.9.8-azul-19 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19.0.1jdk-slim
COPY --from=build /target/bookclub-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bookclub.jar"]
