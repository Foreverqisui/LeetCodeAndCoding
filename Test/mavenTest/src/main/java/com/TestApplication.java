package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author foreverqisui
 */
@SpringBootApplication(scanBasePackages="com.pc")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TestApplication {
        public static void main(String[] args) {
            SpringApplication.run(TestApplication.class,args);
        }
    }

