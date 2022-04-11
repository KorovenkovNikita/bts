package com.vhs.bts.controllers;

import com.vhs.bts.entities.UserEntity;
import com.vhs.bts.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public UserEntity createLaptop(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
    @GetMapping("/id/{id}")
    public List<UserEntity> getById(@PathVariable long id) {
        return userService.getUsersById(id);
    }
    @DeleteMapping("/id/{id}")
    public UserEntity deleteById(@PathVariable long id) {
        return userService.deleteUserById(id);
    }
}
