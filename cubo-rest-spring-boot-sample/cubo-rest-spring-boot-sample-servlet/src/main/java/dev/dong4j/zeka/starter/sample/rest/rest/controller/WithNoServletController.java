package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.starter.rest.ServletController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Description: MatrixVariable 注解测试 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 16:42
 * @since 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("/with_no_servlet")
public class WithNoServletController extends ServletController {


    /**
     * Get
     *
     * @return the object
     * @since 1.7.0
     */
    @RequestMapping("/get")
    public Object get() {
        return "id + name";
    }
}
