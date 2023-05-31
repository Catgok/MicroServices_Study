package com.catgok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication16011 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication16011.class, args);
    }
}
