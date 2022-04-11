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

    @GetMapping("/search/id/{id}")
    public List<LaptopEntity> getById(@PathVariable long id) {
        return laptopService.getDevisesById(id);
    }
    @DeleteMapping("/search/delete/id/{id}")
    public LaptopEntity deleteById(@PathVariable long id) {
        return laptopService.deleteDeviceById(id);
    }
}

