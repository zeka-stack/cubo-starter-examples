package dev.dong4j.zeka.starter.sample.mybatis.integration.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.base.BaseQuery;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.form.UserQuery;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.vo.UserVO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.service.UserService;
import dev.dong4j.zeka.starter.sample.mybatis.integration.wrapper.UserViewConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>Description: 用户信息表 控制器 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.26 20:03
 * @since 1.0.0
 */
@AllArgsConstructor
@RestControllerWrapper
@Api(tags = "用户信息表接口")
public class UserController extends ServletController {
    /** User service */
    private final UserService userService;

    /**
     * 分页 用户信息表, 结果使用 page.convert 转换.
     *
     * @param query 分页查询参数, 继承 {@link BaseQuery}
     * @return the result
     * @since 1.6.0
     */
    @GetMapping("/users/page_1")
    @ApiOperation(value = "用户分页查询实现方式 1")
    public IPage<UserVO> pages1(UserQuery query) {
        IPage<UserDTO> page = this.userService.page(query);
        return page.convert(UserViewConverter.INSTANCE::vo);
    }

    /**
     * 分页 用户信息表, 结果使用 ViewConverterWrapper.vo 转换.
     *
     * @param query 分页查询参数, 继承 {@link BaseQuery}
     * @return the result
     * @since 1.6.0
     */
    @GetMapping("/users/page_2")
    @ApiOperation(value = "用户分页查询实现方式 2")
    public IPage<UserVO> pages2(UserQuery query) {
        IPage<UserDTO> page = this.userService.page(query);
        return UserViewConverter.INSTANCE.vo(page);
    }

    /**
     * 用户列表查询, 返回所有符合要求的数据, 底层会复用 page 分页逻辑.
     *
     * @param query 分页查询参数, 继承 {@link BaseQuery}
     * @return the result
     * @since 1.6.0
     */
    @GetMapping("/users/list")
    @ApiOperation(value = "获取所有用户集合")
    public List<UserVO> list(UserQuery query) {
        List<UserDTO> list = this.userService.list(query);
        return UserViewConverter.INSTANCE.vo(list);
    }

    /**
     * Remove
     *
     * @param ids ids
     * @return the result
     * @since 1.6.0
     */
    @DeleteMapping("/users")
    @ApiOperation(value = "批量删除")
    public Result<Void> remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<Long> ids) {
        return this.userService.removeByIds(ids) ? this.ok() : this.fail("批量删除失败");
    }

    @GetMapping("transactional")
    public Result<Void> transactional() {
        this.userService.transactional();
        return this.ok();
    }

}
