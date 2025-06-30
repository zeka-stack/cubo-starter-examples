package dev.dong4j.zeka.starter.sample.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.sample.mybatis.entity.po.User;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.env.Environment;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.18 15:25
 * @since 1.0.0
 */
@Slf4j
@ZekaTest
class SampleMybatisApplicationTest {
    /** Environment */
    @Resource
    private Environment environment;

    /**
     * Test crud
     *
     * @since 1.0.0
     */
    @Test
    void test_crud() {
        User user = this.insert();
        this.update(user);
        this.select(user);
        this.delete(user);

        Assertions.assertEquals(4, user.selectCount(null));
    }

    /**
     * Insert user using long
     *
     * @return the user using long
     * @since 1.0.0
     */
    User insert() {
        User user = new User();
        user.setName("咩咩");
        user.setAge(5);
        user.setEmail("miemie@mp.com");
        Assertions.assertTrue(user.insert());
        // 成功直接拿会写的 ID
        log.info("\n插入成功 ID 为: {}", user.getId());
        return user;
    }

    /**
     * Update *
     *
     * @param user user
     * @since 1.0.0
     */
    private void update(@NotNull User user) {
        Assertions.assertTrue(user.setEmail("ab@c.c").updateById());
        Assertions.assertTrue(new User().update(new UpdateWrapper<User>()
            .lambda()
            .set(User::getAge, 3)
            .eq(User::getId, 2)));
    }

    /**
     * Select *
     *
     * @param user user
     * @since 1.0.0
     */
    private void select(@NotNull User user) {
        Assertions.assertEquals("ab@c.c", user.selectById().getEmail());
        user = new User().selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 2));
        Assertions.assertEquals("Jack", user.getName());
        Assertions.assertEquals(3, (int) user.getAge());
    }

    /**
     * B delete
     *
     * @param user user
     * @since 1.0.0
     */
    private void delete(@NotNull User user) {
        Assertions.assertTrue(user.deleteById());
        Assertions.assertNull(user.selectById());

        Assertions.assertTrue(new User().delete(new QueryWrapper<User>().lambda().eq(User::getName, "Sandy")));
    }

}
