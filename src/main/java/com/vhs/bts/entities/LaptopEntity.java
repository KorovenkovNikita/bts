package com.vhs.bts.entities;

import com.vhs.bts.dto.LaptopDtoIn;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Table(name = "laptop")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Laptop")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LaptopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
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
    //mappedBy = "laptop"
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Exclude
    private List<StackEntity> stacks = new ArrayList<>();

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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LaptopEntity laptop = (LaptopEntity) o;
        return Objects.equals(name, laptop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
