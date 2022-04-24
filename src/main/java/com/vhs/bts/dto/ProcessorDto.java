package com.vhs.bts.dto;

import com.vhs.bts.entities.ProcessorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessorDto {
    private Long id;
    private String processorManufacturer;
    private String processorNumber;
    private String processorModel;

    public ProcessorDto(ProcessorEntity processor) {
        setId(processor.getId());
        setProcessorManufacturer(processor.getProcessorManufacturer());
        setProcessorNumber(processor.getProcessorNumber());
        setProcessorModel(processor.getProcessorModel());
    }
}
