package com.mwz;

import com.mwz.v1.api.HelloClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
public class V2Application {

    @Autowired
    private HelloClient client;

    @RequestMapping("/")
    public String home() {
        return "Hello World Service-V2";
    }

    @RequestMapping("/s1")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String s1() {
        return client.hello();
    }

    public String fallbackMethod() {
        return "fallbackMethod";
    }

    public static void main(String[] args) {
        SpringApplication.run(V2Application.class, args);
    }
}
