package dev.dong4j.zeka.starter.sample.mybatis.integration.service.impl;

import dev.dong4j.zeka.kernel.common.enums.DeletedEnum;
import dev.dong4j.zeka.kernel.common.enums.EnabledEnum;
import dev.dong4j.zeka.kernel.common.exception.BaseException;
import dev.dong4j.zeka.starter.mybatis.service.impl.BaseServiceImpl;
import dev.dong4j.zeka.starter.sample.mybatis.integration.dao.RuleDao;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.Rule;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.DispatchModeEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.MatchModeEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.service.RuleService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Description: 解析规则 服务接口实现类 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:09
 * @since 1.0.0
 */
@Slf4j
@Service
public class RuleServiceImpl extends BaseServiceImpl<RuleDao, Rule> implements RuleService {
    @Resource
    private RuleDao ruleDao;

    /**
     * Transactional
     *
     * @since 1.6.0
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void transactional() {
        Rule rule = new Rule();
        rule.setIpFrom(127L);
        rule.setIpTo(128L);
        rule.setMatchMode(MatchModeEnum.EQUALS);
        rule.setName("xxx");
        rule.setPriority(1);
        rule.setEnabled(EnabledEnum.OFF);
        rule.setDispatchMode(DispatchModeEnum.IP_HASH);
        rule.setDeleted(DeletedEnum.Y);
        this.ruleDao.insert(rule);

        throw new BaseException();
    }
}
