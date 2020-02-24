FROM java:8-jdk-alpine

COPY ./target/eureka-1.0.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch eureka-1.0.0.jar'

ENTRYPOINT ["java", "-jar", "eureka-1.0.0.jar"]
