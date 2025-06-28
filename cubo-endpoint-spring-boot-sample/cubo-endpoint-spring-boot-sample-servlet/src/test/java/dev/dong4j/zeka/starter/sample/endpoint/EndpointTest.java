package dev.dong4j.zeka.starter.sample.endpoint;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.util.Charsets;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.endpoint.ProjectInfoEndpoint;
import dev.dong4j.zeka.starter.endpoint.initialization.WarmUpEnum;
import dev.dong4j.zeka.starter.endpoint.initialization.WarmUpRequestDTO;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ZekaTest
@WebAppConfiguration
@AutoConfigureMockMvc
@AutoConfigureWebMvc
@ImportAutoConfiguration
public class EndpointTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    void testIndex() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/request-urls"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        Result<List<ProjectInfoEndpoint.RequestToMethodItem>> result =
            JsonUtils.parse(json, new TypeReference<Result<List<ProjectInfoEndpoint.RequestToMethodItem>>>() {
            });

        Assertions.assertNotNull(result);
    }

    @Test
    void testWarmup() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/warmup")
                .content(JsonUtils.toJson(WarmUpRequestDTO.builder()
                    .warmUpString("warm me up")
                    .warmUpNumber(15)
                    .warmUpBigDecimal(BigDecimal.TEN)
                    .warmUpEnumDto(WarmUpEnum.WARM)
                    .build()))
                .characterEncoding(Charsets.UTF_8_NAME)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        Result<WarmUpRequestDTO> result =
            JsonUtils.parse(json, new TypeReference<Result<WarmUpRequestDTO>>() {
            });

        Assertions.assertNotNull(result);
    }
}
