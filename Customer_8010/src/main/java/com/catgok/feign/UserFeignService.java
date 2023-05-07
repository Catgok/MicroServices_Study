package com.catgok.feign;

import com.catgok.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "provider")
public interface UserFeignService {
    @GetMapping(value = "/user/getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id);

    @GetMapping("/user/hello")
    public String hello();

    @GetMapping("/user/get")
    public String get();

    @PostMapping("/user/post")
    public String post();

    @PutMapping("/user/put")
    public String put();

    @DeleteMapping("/user/delete")
    public String delete();
}
