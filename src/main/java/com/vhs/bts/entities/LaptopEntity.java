package com.vhs.bts.entities;

import com.vhs.bts.dto.LaptopDtoIn;
import java.util.List;
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
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private GraphicCardEntity graphicCard;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProcessorEntity processor;
    @ManyToOne(fetch = FetchType.LAZY)
    private ScreenEntity screen;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "laptops")
    private List<BucketEntity> bucket;

    public LaptopEntity(LaptopDtoIn laptopDto, GraphicCardEntity graphicCardEntity, ProcessorEntity processor, ScreenEntity screen) {
        setName(laptopDto.getName());
        setScreen(screen);
        setGraphicCard(graphicCardEntity);
        setProcessor(processor);
    }
}
