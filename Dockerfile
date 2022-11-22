FROM openjdk:8

EXPOSE 8080

RUN mkdir /app

ADD /build/libs/*.jar Spring-boot-docker-image-0.0.1-SNAPSHOT-plain.jar

ENTRYPOINT ["java", "-jar", "/Spring-boot-docker-image-0.0.1-SNAPSHOT-plain.jar"]