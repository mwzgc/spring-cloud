FROM java:8-jdk-alpine

COPY ./target/service-v1-1.0.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch service-v1-1.0.0.jar'

ENTRYPOINT ["java", "-jar", "service-v1-1.0.0.jar"]