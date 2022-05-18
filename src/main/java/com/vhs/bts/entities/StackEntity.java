package com.vhs.bts.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vhs.bts.dto.StackDtoIn;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stack")
public class StackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String address;
    @Column(name = "store_opening_time")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime timeOpen;
    @Column(name = "store_ending_time")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime timeClose;
    @OneToMany(mappedBy = "stack", cascade = CascadeType.ALL, orphanRemoval = true)
    @Exclude
    private List<StackLaptop> laptops = new ArrayList<>();

    public StackEntity(StackDtoIn stackDto) {
        setTitle(stackDto.getTitle());
        setAddress(stackDto.getAddress());
    }

    public void addLaptop(LaptopEntity laptop, Integer quantity) {
        StackLaptop stack = new StackLaptop(this, laptop, quantity);
        laptops.add(stack);
        laptop.getStacks().add(stack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StackEntity that = (StackEntity) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
