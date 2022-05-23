package com.vhs.bts.entities;

import com.vhs.bts.dto.LaptopDtoIn;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Table(name = "laptop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LaptopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @Exclude
    private GraphicCardEntity graphicCard;
    @ManyToOne(fetch = FetchType.LAZY)
    @Exclude
    private ProcessorEntity processor;
    @ManyToOne(fetch = FetchType.LAZY)
    @Exclude
    private ScreenEntity screen;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "laptops")
    @Exclude
    private List<BucketEntity> bucket;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "laptop")
    private List<ProductEntity> products;

    public LaptopEntity(LaptopDtoIn laptopDto, GraphicCardEntity graphicCardEntity, ProcessorEntity processor, ScreenEntity screen) {
        setName(laptopDto.getName());
        setScreen(screen);
        setGraphicCard(graphicCardEntity);
        setProcessor(processor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        LaptopEntity laptop = (LaptopEntity) o;
        return id != null && Objects.equals(id, laptop.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
