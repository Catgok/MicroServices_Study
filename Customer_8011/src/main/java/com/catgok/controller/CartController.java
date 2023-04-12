package com.catgok.controller;

import com.catgok.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PROVIDER");
        ServiceInstance instance = instanceList.get(0);
        return restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/user/hello",
                String.class
        );
    }

    @GetMapping("/addCart/{userId}")
    public User addCart(@PathVariable Integer userId) {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PROVIDER");
        ServiceInstance serviceInstance = instanceList.get(0);
        User result = restTemplate.getForObject(
                "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/getUserById/" + userId.toString(),
                User.class
        );
        return result;
    }
}
