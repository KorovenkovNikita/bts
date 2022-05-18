package com.vhs.bts.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stack_laptop")
public class StackLaptop {

    @EmbeddedId
    private StackLaptopId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stackId")
    private StackEntity stack;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("laptopId")
    private LaptopEntity laptop;
    @Column(name = "quantity")
    private Integer quantity;
    public StackLaptop(StackEntity stack, LaptopEntity laptop,Integer quantity) {
        this.stack = stack;
        this.laptop = laptop;
        this.id = new StackLaptopId(stack.getId(), laptop.getId());
        this.quantity=quantity;
    }


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
