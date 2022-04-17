package com.vhs.bts.controllers;

import com.vhs.bts.dto.LaptopDto;
import com.vhs.bts.dto.LaptopDtoIn;
import com.vhs.bts.entities.LaptopEntity;
import com.vhs.bts.services.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/laptops")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LaptopController {
    private final LaptopService laptopService;

    @GetMapping
    public List<LaptopDto> getLaptops() {
        return laptopService.getLaptops().stream().map(LaptopDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public LaptopDto createLaptop(@RequestBody LaptopDtoIn laptopDto) {
        return new LaptopDto(laptopService.createLaptop(laptopDto));
    }

    @GetMapping("/{id}")
    public LaptopEntity getByLaptopId(@PathVariable long id) {
        return laptopService.getLaptopById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptopById(@PathVariable long id) {
        laptopService.deleteLaptopById(id);
    }

    @PutMapping("/{id}")
    public LaptopDto updateLaptopById(@PathVariable long id, @RequestBody LaptopDtoIn laptopDto) {
        return new LaptopDto(laptopService.updateLaptopById(id,laptopDto));
    }
}

