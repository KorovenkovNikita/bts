package com.vhs.bts.dto;

import com.vhs.bts.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String fullName;
    private String email;

    public UserDto(UserEntity user) {
     setId(user.getId());
     setFullName(user.getFullName());
     setEmail(user.getEmail());
    }
}
