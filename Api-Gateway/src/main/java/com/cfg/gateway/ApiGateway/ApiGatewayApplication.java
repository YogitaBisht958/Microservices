package com.cfg.gateway.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("HOTEL", r -> r
						.path("/hotel/**")
						.uri("lb://HOTEL"))

				.route("RATING", r -> r
								.path("/rating/**")
								.uri("lb://RATING"))
				.route("USER-SERVICE", r -> r
						.path("/users/**")
						.uri("lb://USER-SERVICE"))
				.build();
	}
}
