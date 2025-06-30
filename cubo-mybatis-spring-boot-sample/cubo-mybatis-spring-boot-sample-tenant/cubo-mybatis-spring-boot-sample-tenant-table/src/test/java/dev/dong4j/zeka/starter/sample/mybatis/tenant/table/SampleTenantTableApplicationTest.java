package dev.dong4j.zeka.starter.sample.mybatis.tenant.table;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SQLASTVisitorAdapter;
import java.io.StringWriter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.23 19:59
 * @since 1.0.0
 */
@Slf4j
class SampleTenantTableApplicationTest {
    /**
     * Main
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        String sql = "select * from user where id=1 and name=dong4j group by uid limit 1,200 order by ctime";

        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);

        // 使用Parser解析生成AST,这里SQLStatement就是AST
        SQLStatement sqlStatement = parser.parseStatement();

        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        sqlStatement.accept(visitor);

        log.info("getTables: {}", visitor.getTables());
        log.info("getParameters: {}", visitor.getParameters());
        log.info("getOrderByColumns: {}", visitor.getOrderByColumns());
        log.info("getGroupByColumns: {}", visitor.getGroupByColumns());
        log.info("---------------------------------------------------------------------------");

        // 使用select访问者进行select的关键信息打印
        SelectPrintVisitor selectPrintVisitor = new SelectPrintVisitor();
        sqlStatement.accept(selectPrintVisitor);

        log.info("---------------------------------------------------------------------------");
        // 最终sql输出
        StringWriter out = new StringWriter();
        TableNameVisitor outputVisitor = new TableNameVisitor(out);
        sqlStatement.accept(outputVisitor);
        log.info(out.toString());
    }

    /**
     * 查询语句访问者
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.02.23 14:58
     * @since 2018 /6/1 12:08
     */
    public static class SelectPrintVisitor extends SQLASTVisitorAdapter {

        /**
         * Visit boolean
         *
         * @param x x
         * @return the boolean
         * @since 1.0.0
         */
        @Override
        public boolean visit(@NotNull SQLSelectQueryBlock x) {
            List<SQLSelectItem> selectItemList = x.getSelectList();
            selectItemList.forEach(selectItem -> {
                log.info("attr: {}", selectItem.getAttributes());
                log.info("expr: {}", SQLUtils.toMySqlString(selectItem.getExpr()));
            });

            log.info("table: {}", SQLUtils.toMySqlString(x.getFrom()));
            log.info("where: {}", SQLUtils.toMySqlString(x.getWhere()));
            log.info("order by: {}", SQLUtils.toMySqlString(x.getOrderBy().getItems().get(0)));
            log.info("limit: {}", SQLUtils.toMySqlString(x.getLimit()));

            return true;
        }

    }

    /**
     * 数据库表名访问者
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.02.23 14:58
     * @since 2018 /6/1 11:52
     */
    public static class TableNameVisitor extends MySqlOutputVisitor {

        /**
         * Table name visitor
         *
         * @param appender appender
         * @since 1.0.0
         */
        TableNameVisitor(Appendable appender) {
            super(appender);
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

            // 改写tableName
            this.print0("new_" + tableName.toUpperCase());

            return true;
        }

    }
}
