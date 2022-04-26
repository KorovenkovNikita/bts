package com.vhs.bts.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

@Table(name = "bucket")
@Getter
@Setter
@AllArgsConstructor
@Entity
public class BucketEntity {

    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserEntity user;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<LaptopEntity> laptops;
    @Column(name = "date")
    private Date date;

    public BucketEntity() {
        setDate(Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow")).getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        BucketEntity that = (BucketEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
