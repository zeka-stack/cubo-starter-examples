package dev.dong4j.zeka.starter.sample.mybatis.tenant.table;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dongshijie@gmail.com"
 * @date 2020.02.23 08:20
 * @since 1.0.0
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class SampleShardingApplication extends ZekaStarter {

}
