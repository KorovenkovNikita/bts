package com.vhs.bts.controllers;

import com.vhs.bts.dto.UserDtoIn;
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
    public UserEntity createUser(@RequestBody UserDtoIn userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUserById(@PathVariable Long id, @RequestBody UserDtoIn newUser) {
        return userService.updateUserById(id, newUser);
    }
}
