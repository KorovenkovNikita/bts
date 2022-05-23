package com.vhs.bts.entities;

import com.vhs.bts.dto.AddressStockDtoIn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressStockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;
    @OneToOne(mappedBy = "address")
    private StockEntity stock;

    public AddressStockEntity(AddressStockDtoIn addressStockDtoIn) {
        this.city = addressStockDtoIn.getCity();
        this.address = addressStockDtoIn.getAddress();
    }
}
