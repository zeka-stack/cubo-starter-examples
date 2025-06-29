package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.form.LoginForm;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email dong4j @gmail.com
 * @date 2019.11.23 11:58
 * @since 1.0.0
 */
@RestController
public class FeignTestController extends ServletController {

    /**
     * get 无参数
     *
     * @param request request
     * @return the result
     * @since 1.0.0
     */
    @GetMapping(value = "/get/no/param")
    public Result<Void> getNoParamTest(HttpServletRequest request) {
        return this.ok();
    }

    /**
     * get 路径参数
     *
     * @param request  request
     * @param username username
     * @return the test
     * @since 1.0.0
     */
    @GetMapping("/get/path/{username}")
    public Result<String> getPathParamTest(HttpServletRequest request, @PathVariable("username") String username) {
        return this.ok("get:" + username);
    }

    /**
     * get url 参数
     *
     * @param request  request
     * @param username username
     * @return the test param
     * @since 1.0.0
     */
    @GetMapping("/get/url")
    public Result<String> getUrlParamTest(HttpServletRequest request, @RequestParam("username") String username) {
        return this.ok("get:" + username);
    }

    /**
     * post json 参数, 使用实体接收参数
     * 前端 content-type = MediaType.APPLICATION_JSON_VALUE, 能接收参数
     *
     * @param request   request
     * @param loginForm login form
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post/json/entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> postJsonToEntityTest(HttpServletRequest request, @RequestBody LoginForm loginForm) {
        return this.ok("post:" + JsonUtils.toJson(loginForm));
    }

    /**
     * post json 参数, 字段接收参数
     * 不管前端怎么设置 content-type, 都接收不到参数
     *
     * @param request  request
     * @param username username
     * @param password password
     * @param code     code
     * @param uuid     uuid
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post/json/field", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> postJsonToFieldTest(HttpServletRequest request,
                                              @RequestParam("username") String username,
                                              @RequestParam("password") String password,
                                              @RequestParam("code") String code,
                                              @RequestParam("uuid") String uuid) {
        return this.ok("post:" + JsonUtils.toJson(LoginForm.builder()
            .username(username)
            .password(password)
            .code(code)
            .uuid(uuid)
            .build()));
    }

    /**
     * post formdata 参数, 使用实体接收参数
     * 前端 content-type = MediaType.MULTIPART_FORM_DATA_VALUE, 能接收到 url 和 formdata 参数
     *
     * @param request   request
     * @param loginForm login form
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post/form/entity", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> postFormDataToEntityTest(HttpServletRequest request, LoginForm loginForm) {
        return this.ok("post:" + JsonUtils.toJson(loginForm));
    }

    /**
     * post formdata 参数, 字段接收参数
     * 前端 content-type = MediaType.MULTIPART_FORM_DATA_VALUE, 只能接收 url 中的参数
     *
     * @param request  request
     * @param username username
     * @param password password
     * @param code     code
     * @param uuid     uuid
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post/form/field", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> postFormDataToFieldTest(HttpServletRequest request,
                                                  @RequestParam("username") String username,
                                                  @RequestParam("password") String password,
                                                  @RequestParam("code") String code,
                                                  @RequestParam("uuid") String uuid) {
        return this.ok("post:" + JsonUtils.toJson(LoginForm.builder()
            .username(username)
            .password(password)
            .code(code)
            .uuid(uuid)
            .build()));
    }

    /**
     * post formdata-urlencoded 参数, 实体接收
     * 前端 content-type = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 能接收到 url 和 x-www-form-urlencoded 参数
     *
     * @param request   request
     * @param loginForm login form
     * @param param     param
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post/form/encoded/entity", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Result<String> postFormUrlencodedDataToEntityTest(HttpServletRequest request, LoginForm loginForm, String param) {
        return this.ok("post: " + param + JsonUtils.toJson(loginForm));
    }

    /**
     * post formdata-urlencoded 参数, 字段接收参数
     * 前端 content-type = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 能接收到 url 和 x-www-form-urlencoded 参数
     *
     * @param request  request
     * @param username username
     * @param password password
     * @param code     code
     * @param uuid     uuid
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post/form/encoded/field", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Result<String> postFormUrlencodedDataToFieldTest(HttpServletRequest request,
                                                            @RequestParam("username") String username,
                                                            @RequestParam("password") String password,
                                                            @RequestParam("code") String code,
                                                            @RequestParam("uuid") String uuid) {
        return this.ok("post:" + JsonUtils.toJson(LoginForm.builder()
            .username(username)
            .password(password)
            .code(code)
            .uuid(uuid)
            .build()));
    }


    /**
     * post formdata-urlencoded 参数, 实体接收
     * 前端 content-type = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 能接收到 url 和 x-www-form-urlencoded 参数
     *
     * @param request   request
     * @param loginForm login form
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post_1/form/encoded/entity", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Result<String> postFormUrlencodedDataToEntityTest1(HttpServletRequest request, @RequestBody LoginForm loginForm) {
        return this.ok("post: " + JsonUtils.toJson(loginForm));
    }

    /**
     * post formdata-urlencoded 参数, 字段接收参数
     * 前端 content-type = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 能接收到 url 和 x-www-form-urlencoded 参数
     *
     * @param request  request
     * @param username username
     * @param password password
     * @param code     code
     * @param param    param
     * @param uuid     uuid
     * @return the result
     * @since 1.0.0
     */
    @PostMapping(value = "/post_1/form/encoded/field", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> postFormUrlencodedDataToFieldTest1(HttpServletRequest request,
                                                             @RequestParam("username") String username,
                                                             @RequestParam("password") String password,
                                                             @RequestParam("code") String code,
                                                             @RequestParam("param") String param,
                                                             @RequestParam("uuid") String uuid) {
        return this.ok("post:" + JsonUtils.toJson(LoginForm.builder()
            .username(username)
            .password(password)
            .code(code)
            .uuid(uuid)
            .build()));
    }


    /**
     * Put form urlencoded data to entity test result
     *
     * @param request   request
     * @param loginForm login form
     * @return the result
     * @since 1.0.0
     */
    @PutMapping(value = "/put/form/encoded/entity", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Result<String> putFormUrlencodedDataToEntityTest(HttpServletRequest request, @RequestBody LoginForm loginForm) {
        return this.ok("post: " + JsonUtils.toJson(loginForm));
    }
}
