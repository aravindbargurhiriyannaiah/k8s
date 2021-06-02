package com.funkyganesha.krishna;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Router {
  @Bean
  public RouterFunction<ServerResponse> advise(Advisor advisor) {
    return RouterFunctions.route(GET("/advise").and(accept(MediaType.TEXT_PLAIN)), advisor::advise);
  }

}