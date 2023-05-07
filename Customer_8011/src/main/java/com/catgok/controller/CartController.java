package com.catgok.controller;

import com.catgok.entity.User;
import com.catgok.feign.UserFeignService;
import com.catgok.loadblance.CustomLoadBalanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@LoadBalancerClient(name = "provider", configuration = CustomLoadBalanceConfiguration.class)
public class CartController {
    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/hello")
    public String hello() {
        return userFeignService.hello();
    }

    @GetMapping("/addCart/{userId}")
    public User addCart(@PathVariable Integer userId) {
        return userFeignService.getUserById(userId);
    }

    @GetMapping("/get")
    public String get() {
        return userFeignService.get();
    }

    @GetMapping("/post")
    public String post() {
        return userFeignService.post();
    }

    @GetMapping("/put")
    public String put() {
        return userFeignService.put();
    }

    @GetMapping("/delete")
    public String delete() {
        return userFeignService.delete();
    }
}
