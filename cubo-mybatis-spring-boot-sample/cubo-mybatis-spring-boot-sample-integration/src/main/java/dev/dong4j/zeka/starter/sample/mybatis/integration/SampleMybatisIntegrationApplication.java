package dev.dong4j.zeka.starter.sample.mybatis.integration;

import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.mybatis.handler.MetaObjectChain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 12:28
 * @since 1.0.0
 */
@SpringBootApplication
public class SampleMybatisIntegrationApplication extends ZekaStarter {

    /**
     * 自定义 tenantId 写入逻辑
     *
     * @return 返回 null 则忽略自动补填, 由业务端写入 tenantId dao 表
     * @since 1.8.0
     */
    @Bean
    public MetaObjectChain tenantMetaObjectHandler() {
        return null;
    }
}
