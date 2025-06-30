package dev.dong4j.zeka.starter.sample.mybatis.single.wrapper;

import dev.dong4j.zeka.kernel.common.mapstruct.ServiceConverter;
import dev.dong4j.zeka.starter.sample.mybatis.single.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.single.entity.po.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.05 21:06
 * @since 1.0.0
 */
@Mapper
public interface UserWrapper extends ServiceConverter<UserDTO, User> {

    /** The constant INSTANCE. */
    UserWrapper INSTANCE = Mappers.getMapper(UserWrapper.class);
}
