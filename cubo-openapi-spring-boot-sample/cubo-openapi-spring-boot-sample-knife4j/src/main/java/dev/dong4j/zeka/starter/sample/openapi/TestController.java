package dev.dong4j.zeka.starter.sample.openapi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import dev.dong4j.zeka.kernel.common.api.R;
import dev.dong4j.zeka.kernel.common.api.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:19
 * @since 1.4.0
 */
@Tag(name = "swagger test api")
@RestController
public class TestController {
    /**
     * Find by id result.
     *
     * @param id the id
     * @return the result
     * @since 1.4.0
     */
    @GetMapping("/user/{id}")
    @Operation(summary = "获取用户详情")
    @ApiOperationSupport(order = 1)
    public Result<Void> findById(@Valid @NotNull @Size(min = 1) @PathVariable("id") Long id) {
        return R.succeed();
    }

    /**
     * Save result.
     *
     * @param user the user
     * @return the result
     * @since 1.4.0
     */
    @PostMapping("/user")
    @Operation(summary = "创建新用户")
    @ApiOperationSupport(order = 2)
    public Result<Void> save(@Valid @RequestBody User user) {
        return R.succeed();
    }

    /**
     * Update result.
     *
     * @param user the user
     * @return the result
     * @since 1.4.0
     */
    @PutMapping("/user")
    @Operation(summary = "修改用户信息")
    @ApiOperationSupport(order = 3)
    public Result<String> update(@Valid @RequestBody User user) {
        return R.succeed();
    }

    /**
     * Delete by id result.
     *
     * @param id the id
     * @return the result
     * @since 1.4.0
     */
    @DeleteMapping("/user/{id}")
    @Operation(summary = "删除用户")
    @ApiOperationSupport(order = 4)
    public Result<String> deleteById(@Valid @NotNull @Size(min = 1) @PathVariable("id") Long id) {
        return R.succeed("delete user : " + id);
    }

    /**
     * List.
     *
     * @param pageIndex the page index
     * @param pageSize  the page size
     * @return the list
     * @since 1.4.0
     */
    @GetMapping("/user")
    @Operation(summary = "用户列表")
    @ApiOperationSupport(order = 5)
    public Result<Void> list(Integer pageIndex,
                             Integer pageSize) {
        return R.succeed();
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.4.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.05.08 17:27
     * @since 1.4.0
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class User {
        /** Username */
        @NotBlank(message = "用户名不能为空")
        private String username;
        /** Version */
        private String version;
        /** Date */
        private Date date;
        /** Age */
        @Max(150)
        @Min(1)
        private Integer age;
    }
}
