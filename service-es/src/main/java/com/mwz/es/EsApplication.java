package com.mwz.es;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class EsApplication {

    @RequestMapping("/")
    public String home() {

        return "Hello World Service-ES";
    }

    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class, args);
    }

}
