package com.vhs.bts.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String screenDiagonalInInches;
    private String screenResolution;
    private String screenBrightness;
    private String processorManufacturer;
    private String processorNumber;
    private String processorModel;
    private String graphicsCardManufacturer;
    private String graphicsCardModelNumber;
    private String amountOfVideoMemory;
}
