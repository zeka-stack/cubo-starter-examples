package dev.dong4j.zeka.starter.sample.mybatis.tenant.table.config;

import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class MybatisPlusConfig {

    /**
     * Pagination interceptor pagination interceptor
     *
     * @return the pagination interceptor
     * @since 1.0.0
     */
    @Bean
    @SuppressWarnings(value = {"PMD.UndefineMagicConstantRule", "PMD.RemoveCommentedCodeRule"})
    public PaginationInterceptor paginationInterceptor() {

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {
            private static final long serialVersionUID = 4547149506400470382L;

            {
                this.put("user", new ITableNameHandler() {
                    // todo-dong4j : (2021-10-22 15:56) [新版本适配]
                    // @Override
                    // public String process(MetaObject metaObject, String sql, String tableName) {
                    //     MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                    //     StopWatch stopWatch = new StopWatch();
                    //     stopWatch.start();
                    //
                    //     String dynamicTableName = this.dynamicTableName(metaObject, sql, tableName);
                    //
                    //     // 替换表名
                    //     if (!dynamicTableName.equalsIgnoreCase(tableName)) {
                    //         sql = changeTableNames(sql, tableName, dynamicTableName);
                    //     }
                    //
                    //     stopWatch.stop();
                    //     log.info("{}", stopWatch.getTotalTimeMillis());
                    //     return sql;
                    // }

                    @NotNull
                    @Override
                    public String dynamicTableName(MetaObject metaObject, String sql, String tableName) {
                        // metaObject 可以获取传入参数,这里实现你自己的动态规则
                        String year = "_2018";
                        int random = new Random().nextInt(10);
                        if (random % 2 == 1) {
                            year = "_2019";
                        }
                        return "user" + year;
                    }
                });
            }

        });
        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));

        return paginationInterceptor;
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
