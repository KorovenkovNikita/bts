package com.vhs.bts.services;

import com.vhs.bts.dto.LaptopDtoIn;
import com.vhs.bts.entities.LaptopEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LaptopService {
    private final LaptopRepository laptopRepository;
    private final GraphicCardService graphicCardService;
    private final ProcessorService processorService;
    private final ScreenService screenService;

    public List<LaptopEntity> getLaptops() {
        return laptopRepository.findAll();
    }

    public LaptopEntity createLaptop(LaptopDtoIn laptopDto) {

        return laptopRepository.save(new LaptopEntity(laptopDto, graphicCardService.getGraphicCardById(laptopDto.getGraphicCardId()), processorService.getGraphicCardById(laptopDto.getProcessor()),screenService.getScreenById(laptopDto.getScreen())));
    }

    public LaptopEntity getLaptopById(long id) {
        return laptopRepository.findById(id).orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find laptop with id = " + id));
    }

    public void deleteLaptopById(long id) {
        laptopRepository.deleteById(id);
    }

    public LaptopEntity updateLaptopById(long id, LaptopEntity newLaptopEntity) {
        LaptopEntity laptop = getLaptopById(id);
        laptop.setName(newLaptopEntity.getName());
        laptop.setScreen(newLaptopEntity.getScreen());
        laptop.setGraphicCard(newLaptopEntity.getGraphicCard());
        laptop.setProcessor(newLaptopEntity.getProcessor());
        return laptopRepository.save(laptop);
    }
}
