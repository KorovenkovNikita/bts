package com.vhs.bts.controllers;

import com.vhs.bts.dto.ProcessorDto;
import com.vhs.bts.dto.ProcessorDtoIn;
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
    public ProcessorDto getProcessorById(@PathVariable long id) {
        return new ProcessorDto(processorService.getProcessorById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteProcessorById(@PathVariable long id) {
        processorService.deleteProcessorById(id);
    }

    @PutMapping("/{id}")
    public ProcessorDto updateProcessorById(@PathVariable long id, @RequestBody ProcessorDtoIn processorDto) {
        return new ProcessorDto(processorService.updateProcessorById(id, processorDto));
    }
}
