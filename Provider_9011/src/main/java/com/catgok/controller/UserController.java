package com.catgok.controller;

import com.catgok.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/user")
public class UserController {
    @Value("${msg}")
    private String msg;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World! " + msg;
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id) {
        User u = new User(id, "小明", "password");
        return u;
    }

    @GetMapping("/get")
    public String get() {
        return "执行了provider_9011的get方法";
    }

    @PostMapping("/post")
    public String post() {
        return "执行了provider_9011的post方法";
    }

    @PutMapping("/put")
    public String put() {
        return "执行了provider_9011的put方法";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "执行了provider_9011的delete方法";
    }
}
