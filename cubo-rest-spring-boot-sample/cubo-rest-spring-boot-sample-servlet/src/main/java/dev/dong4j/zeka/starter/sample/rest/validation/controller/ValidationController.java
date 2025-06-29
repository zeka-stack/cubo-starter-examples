package dev.dong4j.zeka.starter.sample.rest.validation.controller;

import dev.dong4j.zeka.kernel.common.api.R;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.starter.sample.rest.validation.vo.UserVO;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 * Validate (Valid 的扩展, 具有分组功能): 用在方法入参上无法单独提供嵌套验证功能. 不能用在成员属性 (字段) 上,也无法提示框架进行嵌套验证. 能配合嵌套验证注解 @Valid 进行嵌套验证.
 * Valid: 用在方法入参上无法单独提供嵌套验证功能. 能够用在成员属性 (字段) 上,提示验证框架进行嵌套验证. 能配合嵌套验证注解 @Valid 进行嵌套验证
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:20
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class ValidationController {

    /**
     * 实体验证, 必须使用 @Valid
     *
     * @param userVO the user vo
     * @return the result
     * @since 1.0.0
     */
    @PostMapping("test1")
    public Result<Void> test1(@Valid @RequestBody UserVO userVO) {
        return R.succeed();
    }

    /**
     * Test 2 result.
     *
     * @param userVO the user vo
     * @return the result
     * @since 1.0.0
     */
    @PostMapping("test2")
    public Result<Void> test2(@RequestBody UserVO userVO) {
        return R.succeed();
    }

    /**
     * test3.name: name 为必填字段, 不能为 null
     *
     * @param name the name
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("tes3")
    public Result<Void> test3(@NotBlank(message = "name 为必填字段") String name) {
        return R.succeed();
    }

    /**
     * 缺少请求参数:  name[String], 可为 null
     *
     * @param name the name
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("tes4")
    public Result<Void> test4(@RequestParam("name") String name) {
        return R.succeed();
    }
}
