package com.dingpeng.java.exercise.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dp
 */

@EnableSwagger2
@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationStarter.class);
        application.run(args);
    }
}
