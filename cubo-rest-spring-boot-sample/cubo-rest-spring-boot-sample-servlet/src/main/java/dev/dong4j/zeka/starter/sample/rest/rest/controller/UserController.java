package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.R;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.form.UserForm;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Description: swagger test controller</p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.03 11:34
 * @since 1.0.0
 */
@Slf4j
@RestControllerWrapper("/users")
public class UserController extends ServletController {

    /**
     * Find by id result.
     *
     * @param id the id
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户详情", notes = "xxx", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
        @ApiResponse(code = 2000, message = "操作成功", response = R.class),
        @ApiResponse(code = 6000, message = "参数校验失败", response = R.class),
        @ApiResponse(code = 4000, message = "用户不存在", response = R.class)
    })
    public Result<User> findById(@Valid @NotNull @PathVariable("id") Long id) {
        return this.ok(User.builder().id(id).name("dong4j").build());
    }

    /**
     * List list.
     *
     * @param pageIndex the page index
     * @param pageSize  the page size
     * @return the list
     * @since 1.0.0
     */
    @GetMapping("/users")
    @ApiOperation(value = "用户列表", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<User>> list(@ApiParam("查看第几页") @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                   @ApiParam("每页多少条") @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        List<User> result = new ArrayList<>();
        result.add(User.builder().age(null).name(null).email("arraydsj@163.com").date(new Date()).build());
        result.add(User.builder().age(null).name(null).email("arraydsj@163.com").date(new Date()).build());
        return R.succeed(result);
    }

    /**
     * Save result.
     *
     * @param user the user
     * @return the result
     * @since 1.0.0
     */
    @PostMapping
    @ApiOperation(value = "创建新用户", notes = "传入一个 User 实体", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Void> save(@Valid @RequestBody UserForm user) {
        return this.ok();
    }

    /**
     * Update result.
     *
     * @param user the user
     * @return the result
     * @since 1.0.0
     */
    @PutMapping
    @ApiOperation(value = "修改用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> update(@Valid @RequestBody UserForm user) {
        return R.succeed();
    }

    /**
     * 删除单个 id
     *
     * @param id the id
     * @return the result
     * @since 1.0.0
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> deleteById(@Valid @NotNull @Size(min = 1) @PathVariable("id") Long id) {
        return R.succeed("delete user : " + id);
    }

    /**
     * json 方式接收 list
     * Content-Type: application/json;charset=UTF-8
     * <p>
     * [
     * 111,
     * 222
     * ]
     *
     * @param ids ids
     * @return the result
     * @since 1.4.0
     */
    @DeleteMapping("/json")
    @ApiOperation(value = "删除多个用户", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> deleteByIds1(@RequestBody List<Long> ids) {
        return R.succeed("delete user : " + ids);
    }

    /**
     * form 表单接收 list
     * DELETE http://127.0.0.1:18767/users/form
     * Content-Type: application/x-www-form-urlencoded
     * <p>
     * id=1&id=2&id=3
     *
     * @param id id
     * @return the result
     * @since 1.4.0
     */
    @DeleteMapping("/form")
    @ApiOperation(value = "删除多个用户", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> deleteByIds2(@RequestParam(value = "id", required = false) List<Long> id) {
        return R.succeed("delete user : " + id);
    }

}
