package dev.dong4j.zeka.starter.sample.launcher.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dongshijie@gmail.com"
 * @date 2020.03.07 20:15
 * @since 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "zeka-stack.app.custom")
public class CustomConfig {

    /** Config 1 */
    @Resource
    private Config1 config1;

    /** Config 2 */
    @Resource
    private Config2 config2;

    /** Aa */
    private String aa;
    /** Cc */
    private String cc;

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.07 20:20
     * @since 1.0.0
     */
    @Data
    @Component
    @ConfigurationProperties(prefix = "zeka-stack.app.custom.config1")
    public static class Config1 {
        /** Value */
        private String value;
        /** Value array */
        private String[] valueArray;
        /** Value list */
        private List<String> valueList;
        /** Value map */
        private Map<String, String> valueMap;
        /** Value map list */
        private List<Map<String, String>> valueMapList;
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.07 20:20
     * @since 1.0.0
     */
    @Data
    @Component
    @ConfigurationProperties(prefix = "zeka-stack.app.custom.config2")
    public static class Config2 {
        /** Value */
        private String key;
    }
}
