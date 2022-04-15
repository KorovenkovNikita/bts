package com.vhs.bts.services;

import com.vhs.bts.entities.ProcessorEntity;
import com.vhs.bts.exceptions.BtsException;
import com.vhs.bts.repositories.ProcessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProcessorService {
    private ProcessorRepository processorRepository;
    public ProcessorEntity getGraphicCardById(long id) {
        return processorRepository.findById(id).orElseThrow(() -> new BtsException(HttpStatus.NOT_FOUND, "Cannot find processor with id = " + id));
    }
}
