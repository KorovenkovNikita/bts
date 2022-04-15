package com.vhs.bts.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "processor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProcessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String processorManufacturer;
    private String processorNumber;
    private String processorModel;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processor")
    private List<LaptopEntity> laptops;
}
