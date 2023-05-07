package com.catgok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerApplication8011 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication8011.class, args);
    }
}
