package com.vhs.bts.dto;

import com.vhs.bts.entities.ScreenEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScreenDto {
    private Long id;
    private String screenDiagonalInInches;
    private String screenResolution;
    private String screenBrightness;

    public ScreenDto(ScreenEntity screen) {
        setId(screen.getId());
        setScreenDiagonalInInches(screen.getScreenDiagonalInInches());
        setScreenResolution(screen.getScreenResolution());
        setScreenBrightness(screen.getScreenBrightness());
    }
}
