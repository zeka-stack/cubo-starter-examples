package dev.dong4j.zeka.starter.sample.mybatis.integration.service;

import dev.dong4j.zeka.starter.sample.mybatis.integration.MybatisApplicationTest;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.form.UserQuery;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.06 11:30
 * @since 1.0.0
 */
@Slf4j
class UserServiceTest extends MybatisApplicationTest {
    /** User service */
    @Resource
    private UserService userService;

    /**
     * Test
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        log.info("{}", this.userService.list().size());
        log.info("{}", this.userService.list());
        log.info("{}", this.userService.list().get(0).getId());
    }

    /**
     * Test 3
     *
     * @since 1.6.0
     */
    @Test
    void test3() {
        UserQuery query = UserQuery.builder().build();
        query.setUserName("dong4j");
        log.info("{}", this.userService.list(query).size());
    }

    /**
     * Test transactional
     *
     * @since 1.7.1
     */
    @Test
    void test_transactional() {
        this.userService.transactional();
    }
}
