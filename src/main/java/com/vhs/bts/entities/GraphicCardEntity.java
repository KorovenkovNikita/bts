package com.vhs.bts.entities;

import com.vhs.bts.dto.GraphicCardDtoIn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "graphic_card")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GraphicCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String modelNumber;
    private Integer memory;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "graphicCard")
    private List<LaptopEntity> laptops;

    public GraphicCardEntity(GraphicCardDtoIn graphicCardDto) {
        setManufacturer(graphicCardDto.getManufacturer());
        setModelNumber(graphicCardDto.getManufacturer());
        setMemory(graphicCardDto.getMemory());
    }
}
