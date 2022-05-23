package com.vhs.bts.entities;

import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "opening_time")
    private LocalTime timeOpen;
    @Column(name = "closing_time")
    private LocalTime timeClose;
    @OneToOne( cascade = CascadeType.ALL)
    private AddressStockEntity address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
    private List<ProductEntity> products;

}
