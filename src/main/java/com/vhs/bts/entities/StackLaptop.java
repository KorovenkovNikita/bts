package com.vhs.bts.entities;

import com.vhs.bts.dto.LaptopDtoIn;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "StackLaptop")
@Table(name = "stack_laptop")
public class StackLaptop {

    @EmbeddedId
    private StackLaptopId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stackId")
    @Exclude
    private StackEntity stack;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("laptopId")
    @Exclude
    private LaptopEntity laptop;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        StackLaptop that = (StackLaptop) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
