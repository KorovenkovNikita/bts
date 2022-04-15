package com.vhs.bts.controllers;

import com.vhs.bts.dto.ProcessorDto;
import com.vhs.bts.dto.ProcessorDtoIn;
import com.vhs.bts.entities.ProcessorEntity;
import com.vhs.bts.services.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/processor")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProcessorController {
    private final ProcessorService processorService;

    @GetMapping
    public List<ProcessorDto> getProcessors() {
        return processorService.getProcessors().stream().map(ProcessorDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public ProcessorDto createProcessor(@RequestBody ProcessorDtoIn processorDto) {
        return new ProcessorDto(processorService.createProcessor(processorDto));
    }

    @GetMapping("/{id}")
    public ProcessorEntity getProcessorById(@PathVariable long id) {
        return processorService.getProcessorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProcessorById(@PathVariable long id) {
        processorService.deleteProcessorById(id);
    }

    @PutMapping("/{id}")
    public ProcessorEntity updateProcessorById(@PathVariable long id, @RequestBody ProcessorEntity newProcessorEntity) {
        return processorService.updateProcessorById(id, newProcessorEntity);
    }
}
