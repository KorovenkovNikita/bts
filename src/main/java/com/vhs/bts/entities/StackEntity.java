package com.vhs.bts.entities;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "Stack")
@Table(name = "stack")
@Embeddable
public class StackEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String address;
//    @Column(name = "store_opening_date")
    private Date dateOpen;
//    @Column(name = "store_ending_date")
    private Date dateClose;
  //  mappedBy = "stack"
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Exclude
    private List<StackLaptop> stackLaptops;

    public StackEntity(List<StackLaptop> laptops) {
        this.stackLaptops = laptops;
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
