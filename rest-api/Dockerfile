FROM openjdk:8-jdk-alpine

RUN mkdir /app
WORKDIR /app
COPY . /app
RUN ./gradlew build

EXPOSE 8080
ENV ACTIVE_PROFILE=dev
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","build/libs/rest-service-0.0.1-SNAPSHOT.jar"]
