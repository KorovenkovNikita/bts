package com.vhs.bts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoIn {
    private String fullName;
    private String email;
}
