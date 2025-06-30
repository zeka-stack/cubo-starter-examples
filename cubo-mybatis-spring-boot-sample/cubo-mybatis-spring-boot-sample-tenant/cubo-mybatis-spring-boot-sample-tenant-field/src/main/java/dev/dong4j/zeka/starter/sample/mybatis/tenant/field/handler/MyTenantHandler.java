package dev.dong4j.zeka.starter.sample.mybatis.tenant.field.handler;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.field.config.MyContext;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import org.springframework.stereotype.Component;

/**
 * <p>Description: 租户处理器 -主要实现mybatis-plus <a href="https://mp.baomidou.com/guide/tenant.html">...</a> </p>
 *
 * @author dong4j
 * @version 1.2.4
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.17 20:51
 * @since 1.0.0
 */
@Slf4j
@Component
public class MyTenantHandler implements TenantHandler {

    /**
     * 多租户标识
     */
    private static final String SYSTEM_TENANT_ID = "tenant_id";

    /**
     * 需要过滤的表
     */
    private static final List<String> IGNORE_TENANT_TABLES = new ArrayList<>();

    /** Api context */
    @Resource
    private MyContext apiContext;

    /**
     * 租户Id
     *
     * @param where where
     * @return tenant id
     * @since 1.0.0
     */
    @Override
    public Expression getTenantId(boolean where) {
        // 从当前系统上下文中取出当前请求的服务商ID,通过解析器注入到SQL中.
        Long tenantId = this.apiContext.getCurrentTenantId();
        log.debug("当前租户为{}", tenantId);
        if (tenantId == null) {
            return new NullValue();
        }
        return new LongValue(tenantId);
    }

    /**
     * 租户字段名
     *
     * @return tenant id column
     * @since 1.0.0
     */
    @Override
    public String getTenantIdColumn() {
        return SYSTEM_TENANT_ID;
    }


    /**
     * 根据表名判断是否进行过滤
     * 忽略掉一些表: 如租户表 (sys_tenant) 本身不需要执行这样的处理
     *
     * @param tableName table name
     * @return boolean boolean
     * @since 1.0.0
     */
    @Override
    public boolean doTableFilter(String tableName) {
        return IGNORE_TENANT_TABLES.stream().anyMatch((e) -> e.equalsIgnoreCase(tableName));
    }
}

