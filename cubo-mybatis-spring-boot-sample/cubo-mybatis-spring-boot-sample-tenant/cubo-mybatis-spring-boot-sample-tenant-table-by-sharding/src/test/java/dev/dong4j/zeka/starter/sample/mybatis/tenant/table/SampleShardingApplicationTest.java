package dev.dong4j.zeka.starter.sample.mybatis.tenant.table;

import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.table.dao.OrderDao;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.23 20:06
 * @since 1.0.0
 */
@ZekaTest
class SampleShardingApplicationTest {

    /** Order dao */
    @Autowired(required = false)
    private OrderDao orderDao;

    /**
     * Test insert order
     *
     * @since 1.0.0
     */
    @Test
    void testInsertOrder() {
        for (int i = 1; i < 20; i++) {
            this.orderDao.insertOrder(new BigDecimal(i), 1L, "SUCCESS");
        }
    }

    /**
     * Test select orderby ids
     *
     * @since 1.0.0
     */
    @Test
    void testSelectOrderbyIds() {

        System.out.println(this.orderDao.selectOrderbyId(435435795839451136L));
    }
}

