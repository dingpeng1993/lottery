package com.dingpeng.java.exercise.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dp
 */

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationStarter.class);
        application.run(args);
    }
}
