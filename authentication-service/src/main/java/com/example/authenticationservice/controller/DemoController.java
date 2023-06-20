package com.example.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
public class DemoController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping()
    public String selectAllUser() {
        return restTemplate.getForObject("http://user-service/user", String.class);
    }

    @GetMapping("/{username}")
    public String selectUser(@PathVariable String username){
        return restTemplate.getForObject("http://user-service/user/" + username, String.class);
    }

    @PostMapping()
    public void addtUser(@RequestBody Object user) {
        restTemplate.postForEntity("http://user-service/user", user, String.class);
    }

    @PutMapping()
    public void updateUser(@RequestBody Object user) {
        restTemplate.put("http://user-service/user", user, String.class);
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        restTemplate.delete("http://user-service/user/" + id, String.class);
    }
}
