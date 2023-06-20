package com.example.userservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.userservice.entity.User;
import com.example.userservice.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Resource
    IUserService userService;

    // 查找所有用户
    @GetMapping()
    public List<User> selectAllUser() {
        return userService.list(null);
    }

    // 按照名字查找
    @GetMapping("/{username}")
    public User selectUser(@PathVariable("username") String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        return userService.getOne(userQueryWrapper);
    }

    // 添加用户
    @PostMapping()
    public void addtUser(@RequestBody User user) {
        userService.save(user);
    }

    // 修改用户信息
    @PutMapping()
    public void updateUser(@RequestBody User user) {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", user.getId());
        userService.update(user, userUpdateWrapper);
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.removeById(id);
    }
}
