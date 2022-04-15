package com.vhs.bts.dto;

import com.vhs.bts.entities.LaptopEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LaptopDto {
    private long id;
    private String name;
    private String screenDiagonalInInches;
    private String screenResolution;
    private ScreenDto screen;
    private ProcessorDto processor;
    private GraphicCardDto graphicCard;

    public LaptopDto(LaptopEntity laptop) {
        setId(laptop.getId());
        setName(laptop.getName());
        setScreen(new ScreenDto(laptop.getScreen()));
        setProcessor(new ProcessorDto(laptop.getProcessor()));
        setGraphicCard(new GraphicCardDto(laptop.getGraphicCard()));
    }
}
