package dev.dong4j.zeka.starter.sample.mybatis.tenant.field;

import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.field.config.MyContext;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.field.dao.UserMapper;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.field.entity.User;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.23 19:55
 * @since 1.0.0
 */
@Slf4j
@ZekaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleTenantFieldApplicationTest {
    /** Api context */
    @Resource
    private MyContext apiContext;
    /** User mapper */
    @Resource
    private UserMapper userMapper;

    /**
     * 模拟当前系统的多租户 Id
     *
     * @since 1.0.0
     */
    @BeforeAll
    void before() {
        // 在上下文中设置当前多租户 id
        this.apiContext.setCurrentTenantId(1L);
    }

    /**
     * Insert
     *
     * @since 1.0.0
     */
    @Test
    void insert() {
        // 新增数据
        User user = new User().setName("dong4j");
        // 判断一个条件是 true 还是 false
        Assertions.assertTrue(this.userMapper.insert(user) > 0);
        user = this.userMapper.selectById(user.getId());
        log.info(" 插入数据:{}", user);
        // 判断是否相等
        Assertions.assertEquals(this.apiContext.getCurrentTenantId(), user.getTenantId());
    }

    /**
     * Select list
     *
     * @since 1.0.0
     */
    @Test
    void selectList() {
        this.userMapper.selectList(null).forEach((e) -> {
            log.info(" 查询数据 {}", e);
            Assertions.assertEquals(this.apiContext.getCurrentTenantId(), e.getTenantId());
        });
    }
}
