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
                //Rotas user-service
                .route("user-service", r -> r.path("/users/")
                        .uri("http://localhost:8081"))
                .route("user-service-by-id", r -> r.path("/users/**")
                        .filters(f -> f.rewritePath("/(?<id>.*)", "/${id}"))
                        .uri("http://localhost:8081"))
                //Rotas zelda-service
                .route("zeda-service", r -> r.path("/api/games")
                        .uri("http://localhost:8085"))
                .route("zelda-service-by-id", r -> r.path("/api/games/**")
                        .filters(f -> f.rewritePath("/(?<id>.*)", "/${id}"))
                        .uri("http://localhost:8085"))
                .build();
    }
}
