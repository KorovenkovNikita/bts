package com.vhs.bts.controllers;

import com.vhs.bts.entities.LaptopEntity;
import com.vhs.bts.services.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LaptopController {
    private final LaptopService laptopService;

    @GetMapping
    public List<LaptopEntity> getLaptops() {
        return laptopService.getLaptops();
    }

    @PostMapping
    public LaptopEntity createLaptop(@RequestBody LaptopEntity laptop) {
        return laptopService.createLaptop(laptop);
    }

    @GetMapping("/search/core/{core}")
    public List<LaptopEntity> getByCore(@PathVariable String core) {
        return laptopService.getDevisesByCore(core);
    }
}

