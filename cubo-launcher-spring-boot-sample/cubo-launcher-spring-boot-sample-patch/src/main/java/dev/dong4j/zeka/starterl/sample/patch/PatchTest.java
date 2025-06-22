package dev.dong4j.zeka.starterl.sample.patch;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Description: patch test</p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dongshijie@gmail.com"
 * @date 2020.05.05 19:40
 * @since 1.0.0
 */
@Slf4j
public class PatchTest {

    static {
        log.info("BBBBBBBBBBBBB");
    }

    /**
     * Patch test
     *
     * @since 1.0.0
     */
    public PatchTest() {
        log.info("Constructor ---> BBBBBBBBBBBBB");
    }
}
