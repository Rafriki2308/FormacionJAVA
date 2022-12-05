package com.bosonit.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class SpringCloudGatewayRouting {

    /*@Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route("customer", r->r.path("/customer/all").uri("lb://BACKEND"))
                .route("trip",r->r.path("/trip/**").uri("http://localhost:8081"))
                .build();
    }*/
}
