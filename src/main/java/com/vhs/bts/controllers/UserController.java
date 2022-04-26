package com.vhs.bts.controllers;

import com.vhs.bts.dto.UserDto;
import com.vhs.bts.dto.UserSlimDto;
import com.vhs.bts.dto.UserDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final DtoConverter dtoConverter;
    private final UserService userService;

    @GetMapping
    public List<UserSlimDto> getUsers() {
        return dtoConverter.simpleConvert(userService.getUsers(), UserSlimDto.class);
    }

    @PostMapping
    public UserSlimDto createUser(@RequestBody UserDtoIn userDto) {
        return dtoConverter.simpleConvert(userService.createUser(userDto), UserSlimDto.class);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return dtoConverter.convertUser(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public UserSlimDto updateUserById(@PathVariable Long id, @RequestBody UserDtoIn newUser) {
        return dtoConverter.simpleConvert(userService.updateUserById(id, newUser), UserSlimDto.class);
    }
}
