package com.vhs.bts.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LaptopDto {
    private Long id;
    private String name;
    private ScreenDto screen;
    private ProcessorDto processor;
    private GraphicCardDto graphicCard;

}
