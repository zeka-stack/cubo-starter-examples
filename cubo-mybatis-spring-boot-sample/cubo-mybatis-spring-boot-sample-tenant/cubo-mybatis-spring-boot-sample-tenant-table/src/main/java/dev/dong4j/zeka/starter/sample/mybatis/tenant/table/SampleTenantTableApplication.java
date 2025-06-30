package dev.dong4j.zeka.starter.sample.mybatis.tenant.table;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dev.dong4j.zeka.kernel.common.context.SpringContext;
import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.table.dao.UserMapper;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.table.po.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 12:28
 * @since 1.0.0
 */
@SpringBootApplication
public class SampleTenantTableApplication extends ZekaStarter {

    /**
     * After
     *
     * @since 1.0.0
     */
    @Override
    @SuppressWarnings("PMD.UndefineMagicConstantRule")
    public void after() {
        UserMapper userMapper = SpringContext.getInstance(UserMapper.class);
        // 自己去观察打印 SQL 目前随机访问 user_2018  user_2019 表
        for (int i = 0; i < 6; i++) {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", 1L).eq("name", "xxx"));
            System.err.println(user.getName());

            userMapper.insert(User.builder().age(1).email("xxx").name("dong4j").build());

            List<User> users = userMapper.selectAll();
            System.err.println(Arrays.toString(users.toArray()));

            userMapper.update();

            userMapper.delete();
        }
    }
}
