package com.vhs.bts.controllers;

import com.vhs.bts.dto.ProcessorDto;
import com.vhs.bts.dto.ProcessorDtoIn;
import com.vhs.bts.mapper.DtoConverter;
import com.vhs.bts.services.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/processor")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProcessorController {

    private final DtoConverter dtoConverter;
    private final ProcessorService processorService;

    @GetMapping
    public List<ProcessorDto> getAllProcessors() {
        return dtoConverter.simpleConvert(processorService.getAllProcessors(), ProcessorDto.class);
    }

    @PostMapping
    public ProcessorDto createProcessor(@RequestBody ProcessorDtoIn processorDto) {
        return dtoConverter.simpleConvert(processorService.createProcessor(processorDto), ProcessorDto.class);
    }

    @GetMapping("/{id}")
    public ProcessorDto getProcessorById(@PathVariable Long id) {
        return dtoConverter.simpleConvert(processorService.getProcessorById(id), ProcessorDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteProcessorById(@PathVariable Long id) {
        processorService.deleteProcessorById(id);
    }

    @PutMapping("/{id}")
    public ProcessorDto updateProcessorById(@PathVariable Long id, @RequestBody ProcessorDtoIn processorDto) {
        return dtoConverter.simpleConvert(processorService.updateProcessorById(id, processorDto), ProcessorDto.class);
    }
}
