package com.vhs.bts.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Embeddable
public class StackLaptopId implements Serializable {

    @Column(name = "stack_id")
    private Long stackId;
    @Column(name = "laptop_id")
    private Long laptopId;


    public StackLaptopId(Long laptopId, Long stackId) {
        setLaptopId(laptopId);
        setStackId(stackId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StackLaptopId that = (StackLaptopId) o;
        return Objects.equals(laptopId, that.laptopId) && Objects.equals(stackId, that.stackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laptopId, stackId);
    }
}
