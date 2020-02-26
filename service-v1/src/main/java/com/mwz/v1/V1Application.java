package com.mwz.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class V1Application {

    @RequestMapping("/")
    public String home() {
        log.error("Hello World Service-V1");
        return "Hello World Service-V1";
    }

    public static void main(String[] args) {
        SpringApplication.run(V1Application.class, args);
    }

}
