package com.vhs.bts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LaptopDtoIn {
    private String name;
    private Long screenId;
    private Long graphicCardId;
    private Long processorId;
}
