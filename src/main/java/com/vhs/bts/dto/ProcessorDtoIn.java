package com.vhs.bts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessorDtoIn {
    private String processorManufacturer;
    private String processorNumber;
    private String processorModel;
}
