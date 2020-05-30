package com.mwz.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

@Configuration
public class Config {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("get-body", r -> r.method(HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT)
                        .filters(f -> f
                                .modifyRequestBody(String.class, String.class, (exchange, body) -> {
                                    exchange.getAttributes().put("body", body);
                                    return Mono.just(body);
                                })
                                .rewritePath("api-service", "")
                        )
                        .uri("lb://api-service")).build();
    }

}
