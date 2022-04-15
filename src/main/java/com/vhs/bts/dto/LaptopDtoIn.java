package com.vhs.bts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LaptopDtoIn {
    private String name;
    private long screen;
    private long graphicCardId;
    private long processor;
}
