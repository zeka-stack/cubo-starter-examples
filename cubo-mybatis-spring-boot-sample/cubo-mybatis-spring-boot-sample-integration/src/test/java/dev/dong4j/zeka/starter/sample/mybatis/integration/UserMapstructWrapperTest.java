package dev.dong4j.zeka.starter.sample.mybatis.integration;

import dev.dong4j.zeka.starter.sample.mybatis.integration.dao.UserDao;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.User;
import dev.dong4j.zeka.starter.sample.mybatis.integration.wrapper.UserMapstructWrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <p>Description: Mapstruct <a href="https://mapstruct.org/documentation/dev/reference/html/">...</a> </p>
 * MapStruct 处理 Java 中枚举 Enum 类型使用 <a href="https://blog.csdn.net/jiangchao858/article/details/77618968">...</a>
 * MapStruct 处理 Java 中实体与模型间不匹配属性转换 <a href="https://blog.csdn.net/jiangchao858/article/details/77604469">...</a>
 * mapstruct+lombok+validator <a href="https://blog.csdn.net/MingLiang000/article/details/82726571">...</a>
 * MapStruct 入门 <a href="https://segmentfault.com/a/1190000011421042">...</a>
 * 优雅的对象转换解决方案 - MapStruct 使用进阶(一) <a href="https://www.cnblogs.com/homejim/p/11306313.html">...</a>
 * 优雅的对象转换解决方案 - MapStruct 使用进阶(二) <a href="https://www.cnblogs.com/homejim/p/11313128.html">...</a>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:10
 * @since 1.0.0
 */
@Slf4j
class UserMapstructWrapperTest extends MybatisApplicationTest {
    /** User dao */
    @Resource
    private UserDao userDao;

    /**
     * Test
     *
     * @since 1.0.0
     */
    @Override
    @Test
    void test() {
        User user = this.userDao.selectById(1L);
        UserDTO userDTO = UserMapstructWrapper.INSTANCE.toDTO(user);
        log.info("{}", userDTO);
        log.info("{}", UserMapstructWrapper.INSTANCE.fromDTO(userDTO));
    }

    /**
     * Test 1
     *
     * @since 1.0.0
     */
    @Test
    void test1() {
        User user = this.userDao.selectById(1L);
        log.info("{}", UserMapstructWrapper.INSTANCE.toVO(user).getGender().getValue());
    }
}
