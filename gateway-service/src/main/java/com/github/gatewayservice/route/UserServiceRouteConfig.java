package com.github.gatewayservice.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceRouteConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("UserServiceGetAllUsers", r -> r.path("/usuario/")
                        .uri("http://localhost:8081"))
                .route("rewrite_route", r -> r.path("/usuario/**")
                        .filters(f -> f.rewritePath("/(?<id>.*)", "/${id}"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
