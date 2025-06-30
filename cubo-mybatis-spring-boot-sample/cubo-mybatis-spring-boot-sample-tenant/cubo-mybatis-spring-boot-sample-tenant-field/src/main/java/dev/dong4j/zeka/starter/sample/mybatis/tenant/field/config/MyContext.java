package dev.dong4j.zeka.starter.sample.mybatis.tenant.field.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

/**
 * <p>Description: 当前系统的上下文 </p>
 *
 * @author dong4j
 * @version 1.2.4
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.17 18:27
 * @since 1.0.0
 */
@Component
public class MyContext {

    /** KEY_CURRENT_TENANT_ID */
    private static final String KEY_CURRENT_TENANT_ID = "KEY_CURRENT_PROVIDER_ID";
    /** M_CONTEXT */
    private static final Map<String, Object> M_CONTEXT = new ConcurrentHashMap<>();

    /**
     * Sets current tenant id *
     *
     * @param tenantId tenant id
     * @since 1.0.0
     */
    public void setCurrentTenantId(Long tenantId) {
        M_CONTEXT.put(KEY_CURRENT_TENANT_ID, tenantId);
    }

    /**
     * Gets current tenant id *
     *
     * @return the current tenant id
     * @since 1.0.0
     */
    public Long getCurrentTenantId() {
        return (Long) M_CONTEXT.get(KEY_CURRENT_TENANT_ID);
    }
}
