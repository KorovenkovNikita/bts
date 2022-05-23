package com.vhs.bts.entities;

import com.vhs.bts.dto.GraphicCardDtoIn;
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

@Table(name = "graphic_card")
@Getter
@Setter
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
    @Exclude
    private List<LaptopEntity> laptops;

    public GraphicCardEntity(GraphicCardDtoIn graphicCardDto) {
        setManufacturer(graphicCardDto.getManufacturer());
        setModelNumber(graphicCardDto.getManufacturer());
        setMemory(graphicCardDto.getMemory());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        GraphicCardEntity that = (GraphicCardEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
