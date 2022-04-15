package com.vhs.bts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphicCardDtoIn {
    private String manufacturer;
    private String modelNumber;
    private int memory;
}
