package com.vhs.bts.controllers;

import com.vhs.bts.dto.LaptopDto;
import com.vhs.bts.dto.LaptopDtoIn;
import com.vhs.bts.entities.LaptopEntity;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LaptopController {

    private final DtoConverter dtoConverter;
    private final LaptopService laptopService;

    @GetMapping
    public List<LaptopDto> getLaptops() {
        return dtoConverter.simpleConvert(laptopService.getLaptops(), LaptopDto.class);
    }

    @PostMapping
    public LaptopDto createLaptop(@RequestBody LaptopDtoIn laptopDto) {
        return dtoConverter.simpleConvert(laptopService.createLaptop(laptopDto), LaptopDto.class);
    }

    @GetMapping("/{id}")
    public LaptopEntity getByLaptopId(@PathVariable Long id) {
        return laptopService.getLaptopById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptopById(@PathVariable Long id) {
        laptopService.deleteLaptopById(id);
    }

    @PutMapping("/{id}")
    public LaptopDto updateLaptopById(@PathVariable Long id, @RequestBody LaptopDtoIn laptopDto) {
        return dtoConverter.simpleConvert(laptopService.updateLaptopById(id, laptopDto), LaptopDto.class);
    }
}

