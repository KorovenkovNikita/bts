package com.vhs.bts.dto;

import com.vhs.bts.entities.GraphicCardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphicCardDto {
    private long id;
    private String manufacturer;
    private String modelNumber;
    private int memory;

    public GraphicCardDto(GraphicCardEntity graphicCard) {
        setId(graphicCard.getId());
        setManufacturer(graphicCard.getManufacturer());
        setModelNumber(graphicCard.getModelNumber());
        setMemory(graphicCard.getMemory());
    }
}
