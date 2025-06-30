package dev.dong4j.zeka.starter.sample.mybatis.integration.wrapper;

import dev.dong4j.zeka.kernel.common.mapstruct.ViewConverter;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.form.UserForm;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>Description: 用户信息表 视图层转换器, 提供 vo 和 dto 互转 </p>
 * form 和 dto 互转需要在此接口中自己添加.
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.09.30 14:18
 * @since 1.0.0
 */
@Mapper
public interface UserViewConverter extends ViewConverter<UserForm, UserDTO, UserVO> {

    /** INSTANCE */
    UserViewConverter INSTANCE = Mappers.getMapper(UserViewConverter.class);
}


