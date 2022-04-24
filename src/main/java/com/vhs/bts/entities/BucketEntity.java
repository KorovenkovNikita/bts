package com.vhs.bts.entities;

import com.vhs.bts.dto.BucketDtoIn;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "bucket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BucketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<LaptopEntity> laptops;

    public BucketEntity(BucketDtoIn bucketDto) {
        setUser(user);
        setLaptops(laptops);
    }
}
