package com.vhs.bts.entities;

import com.vhs.bts.dto.ScreenDtoIn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "screen")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ScreenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String screenDiagonalInInches;
    private String screenResolution;
    private String screenBrightness;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "screen")
    private List<LaptopEntity> laptops;
    public ScreenEntity(ScreenDtoIn screenDto){
        setScreenDiagonalInInches(screenDto.getScreenDiagonalInInches());
        setScreenResolution(screenDto.getScreenResolution());
        setScreenBrightness(screenDto.getScreenBrightness());
    }
}
