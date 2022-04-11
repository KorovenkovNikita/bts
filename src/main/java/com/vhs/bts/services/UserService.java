package com.vhs.bts.services;

import com.vhs.bts.entities.UserEntity;
import com.vhs.bts.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> getUsersById(long id) {
        return userRepository.findAllById(id);
    }

    public UserEntity deleteUserById(long id) {
        return userRepository.deleteById(id);
    }
}
