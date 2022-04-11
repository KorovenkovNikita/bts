package com.vhs.bts.services;

import com.vhs.bts.entities.LaptopEntity;
import com.vhs.bts.repositories.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public List<LaptopEntity> getLaptops() {
        return laptopRepository.findAll();
    }

    public LaptopEntity createLaptop(LaptopEntity laptop) {
        return laptopRepository.save(laptop);
    }

    public List<LaptopEntity> getDevisesById(long id) {
        return laptopRepository.findAllById(id);
    }
    public LaptopEntity deleteDeviceById(long id) {
        return laptopRepository.deleteById(id);
    }
}
