package com.vhs.bts.controllers;

import com.vhs.bts.dto.ScreenDto;
import com.vhs.bts.dto.ScreenDtoIn;
import com.vhs.bts.entities.ScreenEntity;
import com.vhs.bts.services.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/screen")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ScreenController {
    private ScreenService screenService;
    @GetMapping
    public List<ScreenDto> getScreens (){
        return screenService.getScreens().stream().map(ScreenDto::new).collect(Collectors.toList());
    }
    @PostMapping
    public ScreenDto createScreen (@RequestBody ScreenDtoIn screenDto){
        return new ScreenDto(screenService.createScreen(screenDto));
    }
    @GetMapping("/{id}")
    public ScreenEntity getScreenById (@PathVariable long id){
        return screenService.getScreenById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteScreenById (@PathVariable long id){
        screenService.deleteScreenById(id);
    }
    @PutMapping("/{id}")
    public ScreenEntity updateScreenBiId(@PathVariable long id, @RequestBody ScreenEntity newScreenEntity){
        return screenService.updateScreenById(id, newScreenEntity);
    }
}
