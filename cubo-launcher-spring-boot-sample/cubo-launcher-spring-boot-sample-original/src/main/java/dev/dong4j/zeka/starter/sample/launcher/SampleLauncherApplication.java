package dev.dong4j.zeka.starter.sample.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.loader.JarLauncher;

/**
 * <p>Description: debug {@link JarLauncher} </p>
 * https://zhuanlan.zhihu.com/p/112981193
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.04.29 11:54
 * @since 1.0.0
 */
@SpringBootApplication
public class SampleLauncherApplication {

    /**
     * Main
     *
     * @param args args
     * @since 1.0.0
     */
    public static void main(String[] args) {
        SpringApplication.run(SampleLauncherApplication.class, args);
    }

}
