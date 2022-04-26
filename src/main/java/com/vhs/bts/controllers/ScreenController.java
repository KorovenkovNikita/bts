package com.vhs.bts.controllers;

import com.vhs.bts.dto.ScreenDto;
import com.vhs.bts.dto.ScreenDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screen")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ScreenController {

    private final DtoConverter dtoConverter;
    private final ScreenService screenService;

    @GetMapping
    public List<ScreenDto> getScreens() {
        return dtoConverter.simpleConvert(screenService.getScreens(), ScreenDto.class);
    }

    @PostMapping
    public ScreenDto createScreen(@RequestBody ScreenDtoIn screenDto) {
        return dtoConverter.simpleConvert(screenService.createScreen(screenDto), ScreenDto.class);
    }

    @GetMapping("/{id}")
    public ScreenDto getScreenById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(screenService.getScreenById(id), ScreenDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteScreenById(@PathVariable Long id) {
        screenService.deleteScreenById(id);
    }

    @PutMapping("/{id}")
    public ScreenDto updateScreenBiId(@PathVariable Long id, @RequestBody ScreenDtoIn screenDto) {
        return dtoConverter.simpleConvert(screenService.updateScreenById(id, screenDto), ScreenDto.class);
    }
}
