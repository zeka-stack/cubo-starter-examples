package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.05.26 12:00
 * @since 1.9.0
 */
@RestController
public class SpringTrimController extends ServletController {

    /**
     * Url param
     *
     * @param name name
     * @return the string
     * @since 1.9.0
     */
    @GetMapping(value = "/url", produces = MediaType.TEXT_PLAIN_VALUE)
    public String urlParam(String name) {
        return " " + name + " ";
    }

    /**
     * Form param
     *
     * @param u u
     * @return the user
     * @since 1.9.0
     */
    @PostMapping("/form")
    public User formParam(User u) {
        u.setName(" " + u.getName() + " ");
        return u;
    }

    /**
     * Body param
     *
     * @param u u
     * @return the user
     * @since 1.9.0
     */
    @PostMapping(value = "/body")
    public User bodyParam(@RequestBody User u) {
        u.setName(" " + u.getName() + " ");
        return u;
    }
}
