package com.vhs.bts.services;

import com.vhs.bts.dto.UserDtoIn;
import com.vhs.bts.entities.UserEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private final BucketService bucketService;
    private final UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserDtoIn userDto) {
        UserEntity user = userRepository.save(new UserEntity(userDto));
        bucketService.createEmptyBucketByUser(user);
        return user;
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find user with id = " + id));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity updateUserById(Long id, UserDtoIn newUser) {
        UserEntity user = getUserById(id);
        user.setFullName(newUser.getFullName());
        user.setEmail(newUser.getEmail());
        return userRepository.save(user);
    }
}
