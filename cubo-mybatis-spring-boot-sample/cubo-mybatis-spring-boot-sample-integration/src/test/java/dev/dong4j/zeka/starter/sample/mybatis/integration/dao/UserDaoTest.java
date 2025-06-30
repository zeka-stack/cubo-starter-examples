package dev.dong4j.zeka.starter.sample.mybatis.integration.dao;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import dev.dong4j.zeka.kernel.common.constant.ConfigKey;
import dev.dong4j.zeka.kernel.common.context.SpringContext;
import dev.dong4j.zeka.kernel.common.enums.DeletedEnum;
import dev.dong4j.zeka.kernel.common.util.Tools;
import dev.dong4j.zeka.starter.mybatis.support.Condition;
import dev.dong4j.zeka.starter.sample.mybatis.integration.MybatisApplicationTest;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.form.UserQuery;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.User;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.GenderEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.UserStateEnum;
import java.io.IOException;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.06 11:29
 * @since 1.0.0
 */
@Slf4j
class UserDaoTest extends MybatisApplicationTest {
    /** User dao */
    @Resource
    private UserDao userDao;
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * Test save
     *
     * @since 1.7.0
     */
    @Test
    void test_save() {
        User user = new User();
        user.setPhone("18628362906");
        user.setUserName("dong4j");
        user.setNickName("dong4j");
        user.setCompanyName("iHome");
        user.setPassword("xxxx");
        user.setSalt("xxxx");
        user.setApiKey("xxxx");
        user.setSecretKey("xxxx");
        user.setEmail("arraydsj@163.com");
        user.setState(UserStateEnum.NORMAL);
        user.setGender(GenderEnum.MAN);
        user.setDeleted(DeletedEnum.N);

        Tools.repeat(1000, () -> {
            this.userDao.insert(user);
        });
    }

    /**
     * Test insert
     *
     * @since 1.7.0
     */
    @Test
    void test_insert() {
        User user = new User();
        user.setPhone("18628362906");
        user.setUserName("dong4j");
        user.setNickName("dong4j");
        user.setCompanyName("iHome");
        user.setPassword("xxxx");
        user.setSalt("xxxx");
        user.setApiKey("xxxx");
        user.setSecretKey("xxxx");
        user.setEmail("arraydsj@163.com");
        user.setState(UserStateEnum.NORMAL);
        user.setGender(GenderEnum.MAN);
        user.setDeleted(DeletedEnum.N);
        this.userDao.insertIgnore(user);
    }

    /**
     * Test 1
     *
     * @since 1.0.0
     */
    @Test
    void test1() {
        this.userDao.selectById(1L);
        log.info("{}", SpringContext.getApplicationContext().getEnvironment().getProperty(ConfigKey.SpringConfigKey.APPLICATION_NAME));
    }

    /**
     * Test 2
     *
     * @since 1.0.0
     */
    @Test
    void test2() {
        log.info("{}", this.userDao.selectList(Wrappers.query(new User().setPhone("18628362906"))));
    }

    /**
     * Test 3
     *
     * @since 1.6.0
     */
    @Test
    void test3() {
        UserQuery query = UserQuery.builder().build();
        query.setLimit(100);
        query.setUserName("dong4j");
        log.info("{}", this.userDao.page(Condition.getPage(query), query).getRecords().size());
    }


    /**
     * 因为 Cursor 流式计算需要 Session 保持打开，有三种方式可以：
     * 1. @Transactional 开启事务，注意：Spring 框架当中注解只在外部调用时生效。在当前类中调用这个方法，依旧会报错。
     *
     * @since 1.7.0
     */
    @Test
    @Transactional
    void test4() {
        UserQuery query = UserQuery.builder().build();
        query.setLimit(100);
        query.setUserName("dong4j");
        try (Cursor<UserDTO> stream = userDao.stream(query)) {
            stream.forEach(user -> {
                log.info("{}", user);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 因为 Cursor 流式计算需要 Session 保持打开，有三种方式可以：
     * 2. 可以用 SqlSessionFactory 来手工打开数据库连接
     *
     * @since 1.7.0
     */
    @Test
    void test4_2() {
        UserQuery query = UserQuery.builder().build();
        query.setLimit(100);
        query.setUserName("dong4j");
        try (SqlSession sqlSession = sqlSessionFactory.openSession();
             Cursor<UserDTO> stream = sqlSession.getMapper(UserDao.class).stream(query)) {
            stream.forEach(user -> {
                log.info("{}", user);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
