package com.funkyganesha.arjuna;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class Seeker {

  public Mono<ServerResponse> seek(ServerRequest serverRequest) {
    Mono<String> mono =
        WebClient.create("http://localhost:9070")
            .get()
            .uri("/advise")
            .accept(MediaType.TEXT_PLAIN)
            .retrieve()
            .bodyToMono(String.class);
    log.info("Was advised by Krishna");
    return ServerResponse.ok()
        .contentType(MediaType.TEXT_PLAIN)
        .body(BodyInserters.fromPublisher(mono, String.class));
  }
}
