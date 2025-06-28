package dev.dong4j.zeka.starter.sample.endpoint;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.endpoint.initialization.WarmUpEnum;
import dev.dong4j.zeka.starter.endpoint.initialization.WarmUpRequestDTO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@ZekaTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureCache
@AutoConfigureJson
@AutoConfigureWebFlux
@AutoConfigureWebTestClient
@ImportAutoConfiguration
public class EndpointReactiveTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testWarmup() {
        WarmUpRequestDTO dto = WarmUpRequestDTO.builder()
            .warmUpString("warm me up")
            .warmUpNumber(15)
            .warmUpBigDecimal(BigDecimal.TEN)
            .warmUpEnumDto(WarmUpEnum.WARM)
            .build();

        webTestClient.post().uri("/warmup")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(dto), WarmUpRequestDTO.class)
            .exchange()
            .expectStatus().isOk()
            .expectBody(new ParameterizedTypeReference<Result<WarmUpRequestDTO>>() {
            })
            .consumeWith(response -> {
                Result<WarmUpRequestDTO> result = response.getResponseBody();
                assertThat(result).isNotNull();
                assertThat(result.getData()).isNotNull();
                assertThat(result.getData().getWarmUpString()).isEqualTo("warm me up");
            });
    }
}
