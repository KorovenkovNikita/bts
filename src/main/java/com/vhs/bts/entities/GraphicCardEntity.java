package com.vhs.bts.entities;

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
    private long id;
    private String manufacturer;
    private String modelNumber;
    private int memory;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "graphicCard")
    private List<LaptopEntity> laptops;
}
