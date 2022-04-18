package com.vhs.bts.services;

import com.vhs.bts.dto.LaptopDto;
import com.vhs.bts.dto.LaptopDtoIn;
import com.vhs.bts.entities.LaptopEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.LaptopRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Configuration
@EnableScheduling
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class LaptopService {

    private final LaptopRepository laptopRepository;
    private final GraphicCardService graphicCardService;
    private final ProcessorService processorService;
    private final ScreenService screenService;

    @Scheduled(cron = "0 * * * * *")
    public void scheduleTaskUsingCronExpression() {
        log.info("Laptops available: \n{}", getLaptops().stream()
            .map(LaptopEntity::getName).collect(Collectors.joining("\n")));
    }

    public List<LaptopEntity> getLaptops() {
        return laptopRepository.findAll();
    }

    public LaptopEntity createLaptop(LaptopDtoIn laptopDto) {
        log.info("Create new laptop: {}", laptopDto.getName());
        return laptopRepository.save(new LaptopEntity(laptopDto, graphicCardService.getGraphicCardById(laptopDto.getGraphicCardId()),
            processorService.getProcessorById(laptopDto.getProcessorId()), screenService.getScreenById(laptopDto.getScreenId())));
    }

    public LaptopEntity getLaptopById(long id) {
        return laptopRepository.findById(id)
            .orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find laptop with id = " + id));
    }

    public void deleteLaptopById(long id) {
        laptopRepository.deleteById(id);
    }

    public LaptopEntity updateLaptopById(long id, LaptopDtoIn laptopDto) {
        LaptopEntity laptop = getLaptopById(id);
        laptop.setName(laptopDto.getName());
        laptop.setScreen(screenService.getScreenById(laptopDto.getScreenId()));
        laptop.setGraphicCard(graphicCardService.getGraphicCardById(laptopDto.getGraphicCardId()));
        laptop.setProcessor(processorService.getProcessorById(laptopDto.getProcessorId()));
        return laptopRepository.save(laptop);
    }
}
