package com.vhs.bts.entities;

import com.vhs.bts.dto.ProcessorDtoIn;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Table(name = "processor")
@Getter
@Setter
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
    @Exclude
    private List<LaptopEntity> laptops;

    public ProcessorEntity(ProcessorDtoIn processorDto) {
        setProcessorManufacturer(processorDto.getProcessorManufacturer());
        setProcessorNumber(processorDto.getProcessorNumber());
        setProcessorModel(processorDto.getProcessorModel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ProcessorEntity that = (ProcessorEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
