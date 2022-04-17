package com.vhs.bts.services;


import com.vhs.bts.dto.ScreenDtoIn;
import com.vhs.bts.entities.ScreenEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenEntity getScreenById(long id) {
        return screenRepository.findById(id)
            .orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find screen with id = " + id));
    }

    public List<ScreenEntity> getScreens() {
        return screenRepository.findAll();
    }

    public ScreenEntity createScreen(ScreenDtoIn screenDto) {
        return screenRepository.save(new ScreenEntity(screenDto));
    }

    public void deleteScreenById(long id) {
        screenRepository.deleteById(id);
    }

    public ScreenEntity updateScreenById(long id, ScreenDtoIn screenDto) {
        ScreenEntity screen = getScreenById(id);
        screen.setScreenDiagonalInInches(screenDto.getScreenDiagonalInInches());
        screen.setScreenResolution(screenDto.getScreenResolution());
        screen.setScreenBrightness(screenDto.getScreenBrightness());
        return screenRepository.save(screen);
    }
}
