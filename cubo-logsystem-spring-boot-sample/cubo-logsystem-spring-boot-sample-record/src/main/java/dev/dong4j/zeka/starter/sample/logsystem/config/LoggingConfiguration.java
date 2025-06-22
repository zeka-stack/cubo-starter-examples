package dev.dong4j.zeka.starter.sample.logsystem.config;

import dev.dong4j.zeka.starter.logsystem.entity.ApiLog;
import dev.dong4j.zeka.starter.logsystem.entity.ErrorLog;
import dev.dong4j.zeka.starter.logsystem.entity.SystemLog;
import dev.dong4j.zeka.starter.logsystem.factory.LogStorageFactory;
import dev.dong4j.zeka.starter.logsystem.factory.LogStorageFactoryAdapter;
import dev.dong4j.zeka.starter.logsystem.storage.ILogStorage;
import dev.dong4j.zeka.starter.sample.logsystem.service.ApiLogStorageService;
import dev.dong4j.zeka.starter.sample.logsystem.service.ErrorLogStorageService;
import dev.dong4j.zeka.starter.sample.logsystem.service.SystemLogStorageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2019.11.21 14:06
 * @since 1.0.0
 */
@Configuration
public class LoggingConfiguration {

    /**
     * Log storage factory log storage factory
     *
     * @return the log storage factory
     * @since 1.0.0
     */
    @Bean
    public LogStorageFactory logStorageFactory() {
        return new LogStorageFactoryAdapter() {

            @Override
            public ILogStorage<SystemLog> getSystemLogStorage() {
                return LoggingConfiguration.this.systemLogStorageService();
            }

            @Override
            public ILogStorage<ErrorLog> getErrorLogStorage() {
                return LoggingConfiguration.this.errorLogStorageService();
            }

            @Override
            public ILogStorage<ApiLog> getApiLogStorage() {
                return LoggingConfiguration.this.apiLogStorageService();
            }
        };
    }

    /**
     * System log storage service system log storage service
     *
     * @return the system log storage service
     * @since 1.0.0
     */
    @Bean
    public SystemLogStorageService systemLogStorageService() {
        return new SystemLogStorageService();
    }

    /**
     * Error log storage service error log storage service
     *
     * @return the error log storage service
     * @since 1.0.0
     */
    @Bean
    public ErrorLogStorageService errorLogStorageService() {
        return new ErrorLogStorageService();
    }

    /**
     * Api log storage service api log storage service
     *
     * @return the api log storage service
     * @since 1.0.0
     */
    @Bean
    public ApiLogStorageService apiLogStorageService() {
        return new ApiLogStorageService();
    }
}
