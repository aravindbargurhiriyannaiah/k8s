package com.funkyganesha.arjuna;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.get;

@SpringBootTest
@AutoConfigureWebTestClient
class RouterTest {
  @Autowired private WebTestClient client;

  private WireMockServer wireMockServer;

  @BeforeEach
  public void beforeEachUnitTest() {
    wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(9070));
    wireMockServer.start();
  }

  @AfterEach
  public void afterEachUnitTest() {
    wireMockServer.stop();
  }

  @Test
  public void testAdvise() {
    wireMockServer.stubFor(get("/advise").willReturn(WireMock.ok("Some advice")));
    Assertions.assertNotNull(client
            .get()
            .uri("/advise")
            .accept(MediaType.TEXT_PLAIN)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(String.class).returnResult().getResponseBody());
  }
}
