package com.vhs.bts.entities;

import com.vhs.bts.dto.LaptopDtoIn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "laptop")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private GraphicCardEntity graphicCard;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProcessorEntity processor;
    @ManyToOne(fetch = FetchType.LAZY)
    private ScreenEntity screen;

    public LaptopEntity(LaptopDtoIn laptopDto, GraphicCardEntity graphicCardEntity, ProcessorEntity processor, ScreenEntity screen) {
        setName(laptopDto.getName());
        setScreen(screen);
        setGraphicCard(graphicCardEntity);
        setProcessor(processor);
    }
}
