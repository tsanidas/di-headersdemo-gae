package com.diveinsoft.blog.headers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Small GAE-hosted REST API for headers demo
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.diveinsoft.blog.headers.MainApplication.class, args);
    }
}