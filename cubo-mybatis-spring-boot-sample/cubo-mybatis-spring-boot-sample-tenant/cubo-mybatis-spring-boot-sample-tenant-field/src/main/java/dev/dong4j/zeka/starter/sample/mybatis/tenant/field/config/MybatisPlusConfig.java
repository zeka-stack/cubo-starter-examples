package dev.dong4j.zeka.starter.sample.mybatis.tenant.field.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.field.handler.MyTenantHandler;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.mapping.MappedStatement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.2.4
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.17 18:25
 * @since 1.0.0
 */
@Configuration
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
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // SQL解析处理拦截: 增加租户处理回调.
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链
        sqlParserList.add(new BlockAttackSqlParser());
        // 多租户拦截
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(this.myTenantHandler);
        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);

        paginationInterceptor.setSqlParserFilter(metaObject -> {
            MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
            // 过滤自定义查询此时无租户信息约束
            return USER_LIST.equals(ms.getId());
        });

        return paginationInterceptor;
    }
}

