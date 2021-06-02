package com.funkyganesha.krishna;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class Advisor {
  private static final List<String> advices =
      Arrays.asList(
          "The wise work for the welfare of the world, without thought for themselves.",
          "You have the right to work, but never to the fruit of work, You should never engage in action for the sake of reward, nor should you long for inaction.",
          "There is nothing lost or wasted in this life.",
          "Perform your obligatory duty, because action is indeed better than inaction.",
          "He who is deluded by the ego thinks, I am the doer.",
          "The mind acts like an enemy for those who do not control it.",
          "Those who are motivated only by desire for the fruits of action are miserable, for they are constantly anxious about the results of what they do.");

  public Mono<ServerResponse> advise(ServerRequest serverRequest) {
    String advice = advices.get(new Random().nextInt(advices.size()));
    log.info("Advice: {}", advice);
    return ServerResponse.ok()
        .contentType(MediaType.TEXT_PLAIN)
        .body(BodyInserters.fromValue(advice));
  }
}
