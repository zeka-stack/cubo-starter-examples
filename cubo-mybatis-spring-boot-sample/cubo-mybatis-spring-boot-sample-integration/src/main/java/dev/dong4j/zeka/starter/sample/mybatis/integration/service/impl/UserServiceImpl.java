package dev.dong4j.zeka.starter.sample.mybatis.integration.service.impl;

import dev.dong4j.zeka.kernel.common.enums.DeleteEnum;
import dev.dong4j.zeka.starter.mybatis.service.impl.BaseServiceImpl;
import dev.dong4j.zeka.starter.sample.mybatis.integration.dao.UserDao;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.User;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.GenderEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.UserStatusEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.service.RuleService;
import dev.dong4j.zeka.starter.sample.mybatis.integration.service.UserService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Description: 用户信息表 服务接口实现类 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:09
 * @since 1.0.0
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private RuleService ruleService;

    /**
     * Transactional
     *
     * @since 1.6.0
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void transactional() {
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
        user.setStatus(UserStatusEnum.NORMAL);
        user.setGender(GenderEnum.MAN);
        user.setDeleted(DeleteEnum.N);
        this.userDao.insert(user);

        this.ruleService.transactional();
    }
}
