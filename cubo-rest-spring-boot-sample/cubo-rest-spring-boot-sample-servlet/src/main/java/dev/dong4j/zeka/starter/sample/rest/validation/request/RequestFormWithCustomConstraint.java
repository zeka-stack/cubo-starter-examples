package dev.dong4j.zeka.starter.sample.rest.validation.request;

import dev.dong4j.zeka.starter.sample.rest.validation.validation.NameConstraint;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:19
 * @since 1.0.0
 */
public class RequestFormWithCustomConstraint {

    /** Name */
    @NameConstraint(allowedValues = {"bar", "foo"}, message = " 只允许 bar,foo")
    private String name;

    /**
     * Gets name *
     *
     * @return the name
     * @since 1.0.0
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name *
     *
     * @param name name
     * @since 1.0.0
     */
    public void setName(String name) {
        this.name = name;
    }

}
