package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.advice.ResponseWrapperAdvice;
import dev.dong4j.zeka.starter.rest.annotation.OriginalResponse;
import dev.dong4j.zeka.starter.rest.handler.CustomizeReturnValueHandler;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.05.08 09:48
 * @since 1.9.0
 */
@RestController
@RequestMapping("/wrapper")
public class ResponseWriteController extends ServletController {

    /**
     * 使用 response 写数据, 需要添加 Content-Type, 非 json 则不包装.
     * 由于返回值类型为 void, 在 {@link CustomizeReturnValueHandler#handleReturnValue} 直接放行,
     * 然后在 {@link ResponseWrapperAdvice#beforeBodyWrite} 处理 Content-type (因为没有使用 {@link OriginalResponse})
     *
     * @throws IOException io exception
     * @since 1.7.3
     */
    @GetMapping("/test1")
    public void test1() throws IOException {
        this.response.setContentType("text/html");
        this.response.getWriter().write("<script></script>");
    }

    /**
     * 会被包装为 map, 因为使用了 {@link RestController}, 默认所有的数据都是 json, 这里返回类型为 String,
     * 且没有显式设置 response Content-type 或 produces 为 非 json.
     *
     * @return the string
     * @throws IOException io exception
     * @since 1.8.0
     */
    @GetMapping("/test2")
    public String test2() throws IOException {
        return "<script></script>";
    }

    /**
     * 不会被包装, 使用 response 的 Content-Type 判断.
     * 因为返回类型为 void, 在 {@link CustomizeReturnValueHandler#handleReturnValue} 直接放行,
     * 然后在 {@link ResponseWrapperAdvice#beforeBodyWrite} 处理 Content-type (因为没有使用 {@link OriginalResponse}).
     * 不会使用到 {@link GetMapping#produces()}
     *
     * @return the string
     * @throws IOException io exception
     * @since 1.8.0
     */
    @GetMapping(value = "/test3", produces = "application/xml")
    public void test3() throws IOException {
        this.response.setContentType("text/html");
        this.response.getWriter().write("<script></script>");
    }

    /**
     * 返回的类型为非 json, 则不包装
     *
     * @return the string
     * @since 1.8.0
     */
    @GetMapping(value = "/test4", produces = "application/xml")
    public String test4() {
        return "<script></script>";
    }

    /**
     * 包装
     *
     * @return the string
     * @since 1.8.0
     */
    @GetMapping(value = "/test5", produces = "application/json")
    public String test5() {
        return "<script></script>";
    }

    /**
     * 包装
     *
     * @throws IOException io exception
     * @since 1.8.0
     */
    @GetMapping(value = "/test6")
    public void test6() throws IOException {
        this.response.setContentType("application/json");
        this.response.getWriter().write("{\"aa\":\"bb\"}");
    }

    /**
     * 包装
     *
     * @return the string
     * @since 1.8.0
     */
    @GetMapping(value = "/test7", produces = "application/xml")
    public String test7() {
        this.response.setContentType("application/json");
        return "<script></script>";
    }

    /**
     * 不包装
     *
     * @return the string
     * @since 1.8.0
     */
    @GetMapping(value = "/test8", produces = "application/json")
    public String test8() {
        this.response.setContentType("application/xml");
        return "<script></script>";
    }
}
