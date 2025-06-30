package dev.dong4j.zeka.starter.sample.mybatis.single;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dev.dong4j.zeka.kernel.common.context.SpringContext;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.sample.mybatis.single.dao.UserDao;
import dev.dong4j.zeka.starter.sample.mybatis.single.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.single.entity.po.User;
import dev.dong4j.zeka.starter.sample.mybatis.single.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.05 16:35
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class SampleMybatisSingleApplication extends ZekaStarter {

    /**
     * Run *
     *
     * @param args args
     * @since 1.0.0
     */
    @Override
    public void run(String... args) {
        UserDao userMapper = SpringContext.getInstance(UserDao.class);

        User user = userMapper.selectById(1);
        log.info("{}", JsonUtils.toJson(user));

        userMapper.insert(UserWrapper.INSTANCE.po(UserDTO.builder().age(1).email("xxx").name("dong4j").build()));
        log.info("{}", JsonUtils.toJson(userMapper.selectList(new QueryWrapper<>())));
    }
}
