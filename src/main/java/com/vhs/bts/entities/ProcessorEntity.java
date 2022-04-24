package com.vhs.bts.entities;

import com.vhs.bts.dto.ProcessorDtoIn;
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
    private Long id;
    private String processorManufacturer;
    private String processorNumber;
    private String processorModel;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processor")
    private List<LaptopEntity> laptops;

    public ProcessorEntity(ProcessorDtoIn processorDto) {
        setProcessorManufacturer(processorDto.getProcessorManufacturer());
        setProcessorNumber(processorDto.getProcessorNumber());
        setProcessorModel(processorDto.getProcessorModel());
    }
}
