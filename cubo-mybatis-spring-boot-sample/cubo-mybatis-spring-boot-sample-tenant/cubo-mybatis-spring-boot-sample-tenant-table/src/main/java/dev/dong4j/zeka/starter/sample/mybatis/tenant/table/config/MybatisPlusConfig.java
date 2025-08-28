package dev.dong4j.zeka.starter.sample.mybatis.tenant.table.config;

import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.table.handler.MyTenantHandler;
import java.io.StringWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * <p>Description: </p>
 *
 * @author miemie
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.23 14:28
 * @since 2018 -08-10
 */
@Slf4j
@AutoConfiguration
public class MybatisPlusConfig {

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

    /**
     * Table names string
     *
     * @param sql               sql
     * @param originalTableName original table name
     * @param dynamicTableName  dynamic table name
     * @return the string
     * @since 1.0.0
     */
    @SneakyThrows
    private static String changeTableNames(String sql, String originalTableName, String dynamicTableName) {
        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);

        // 使用Parser解析生成AST,这里SQLStatement就是AST
        SQLStatement sqlStatement = parser.parseStatement();
        // 最终sql输出
        StringWriter out = new StringWriter();
        TableNameVisitor outputVisitor = new TableNameVisitor(out, originalTableName, dynamicTableName);
        sqlStatement.accept(outputVisitor);
        log.info(out.toString());
        return out.toString();
    }

    /**
     * 数据库表名访问者
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.02.23 14:58
     * @since 1.0.0
     */
    private static class TableNameVisitor extends MySqlOutputVisitor {

        /** Original table name */
        private final String originalTableName;
        /** Dynamic table name */
        private final String dynamicTableName;

        /**
         * Table name visitor
         *
         * @param appender          appender
         * @param originalTableName original table name
         * @param dynamicTableName  dynamic table name
         * @since 1.0.0
         */
        TableNameVisitor(Appendable appender, String originalTableName, String dynamicTableName) {
            super(appender);
            this.originalTableName = originalTableName;
            this.dynamicTableName = dynamicTableName;
        }

        /**
         * Visit boolean
         *
         * @param x x
         * @return the boolean
         * @since 1.0.0
         */
        @Override
        public boolean visit(@NotNull SQLExprTableSource x) {
            SQLName table = (SQLName) x.getExpr();
            String tableName = table.getSimpleName();

            if (tableName.equalsIgnoreCase(this.originalTableName)) {
                this.print0(this.dynamicTableName.toUpperCase());
            } else {
                this.print0(tableName.toLowerCase());
            }

            this.printAlias(x.getAlias());
            return false;
        }

    }

}
