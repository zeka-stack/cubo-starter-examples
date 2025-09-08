package dev.dong4j.zeka.starter.sample.mybatis.tenant.field.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.field.handler.MyTenantHandler;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.17 18:25
 * @since 1.0.0
 */
@AutoConfiguration
public class MybatisPlusConfig {

    /** USER_LIST */
    private static final String USER_LIST = "dev.dong4j.zeka.starter.sample.mybatis.tenant.field.dao.UserMapper.selectListBySQL";
    /** My tenant handler */
    @Resource
    private MyTenantHandler myTenantHandler;

    /**
     * Pagination interceptor pagination interceptor
     *
     * @return the pagination interceptor
     * @since 1.0.0
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 多租户插件
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new MyTenantHandler()));

        // 针对 update 和 delete 语句 作用: 阻止恶意的全表更新删除
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());

        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return interceptor;
    }
}

