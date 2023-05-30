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

import java.util.concurrent.CompletableFuture;

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
    public CompletableFuture<User> addCart(@PathVariable Integer userId) throws InterruptedException {
        System.out.println("进入方法");
        CompletableFuture<User> result = CompletableFuture.supplyAsync(() -> {
            return userFeignService.getUserById(userId);
        });
        System.out.println("离开方法");
        return result;
    }

    public CompletableFuture<User> addCartFallBack(@PathVariable Integer userId, Throwable e) {
        e.printStackTrace();
        System.out.println("调用fallback");
        CompletableFuture<User> result = CompletableFuture.supplyAsync(() -> {
            return new User(400, "用户服务错误", "");
        });
        return result;
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
