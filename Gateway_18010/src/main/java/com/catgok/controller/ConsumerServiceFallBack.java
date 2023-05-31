package com.catgok.controller;

import com.catgok.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerServiceFallBack {
    @GetMapping("/addCartGatewayFallBack")
    public User addCartFallBack() {
        return new User(400, "由于Gateway服务异常,发生服务降级", "");
    }
}
