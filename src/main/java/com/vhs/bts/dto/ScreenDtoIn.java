package com.vhs.bts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScreenDtoIn {
    private String screenDiagonalInInches;
    private String screenResolution;
    private String screenBrightness;
}
