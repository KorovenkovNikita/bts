package com.vhs.bts.controllers;


import com.vhs.bts.dto.LaptopDto;
import com.vhs.bts.dto.NumberOfLaptopsInStackDtoIn;
import com.vhs.bts.dto.StackDto;
import com.vhs.bts.dto.StackDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.StackService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stack")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StackController {

    private final StackService stackService;
    private final DtoConverter dtoConverter;

    @GetMapping
    public List<StackDto> getStacks() {
        return dtoConverter.simpleConvert(stackService.getStacks(), StackDto.class);
    }

    @PostMapping
    public StackDto createStack(@RequestBody StackDtoIn stackDto) {
        return dtoConverter.simpleConvert(stackService.createEmptyStack(stackDto), StackDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteStackById(@PathVariable Long id) {
        stackService.deleteStackById(id);
    }

    @GetMapping("/{id}")
    public StackDto getByStackId(@PathVariable Long id) {
        return dtoConverter.simpleConvert(stackService.getStackById(id), StackDto.class);
    }

    @PutMapping("/{id}")
    public StackDto changeLaptopsInTheStack(@RequestBody List<NumberOfLaptopsInStackDtoIn> numberOfLaptopsInStackDto, @PathVariable Long id) {
        return dtoConverter.simpleConvert(
            stackService.changeLaptopsInTheStackById(numberOfLaptopsInStackDto, id), StackDto.class);
    }
}
