package com.vhs.bts.services;

import com.vhs.bts.dto.ProcessorDtoIn;
import com.vhs.bts.entities.ProcessorEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.ProcessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProcessorService {
    private final ProcessorRepository processorRepository;

    public List<ProcessorEntity> getProcessors() {
        return processorRepository.findAll();
    }

    public ProcessorEntity getProcessorById(Long id) {
        return processorRepository.findById(id).orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find processor with id = " + id));
    }
    
    public ProcessorEntity createProcessor(ProcessorDtoIn processorDto) {
        return processorRepository.save(new ProcessorEntity(processorDto));
    }

    public void deleteProcessorById(Long id) {
        processorRepository.deleteById(id);
    }

    public ProcessorEntity updateProcessorById(Long id, ProcessorDtoIn newProcessorEntity) {
        ProcessorEntity processor = getProcessorById(id);
        processor.setProcessorManufacturer(newProcessorEntity.getProcessorManufacturer());
        processor.setProcessorNumber(newProcessorEntity.getProcessorNumber());
        processor.setProcessorModel(newProcessorEntity.getProcessorModel());
        return processorRepository.save(processor);
    }
}
