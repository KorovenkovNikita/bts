package com.vhs.bts.repositories;

import com.vhs.bts.entities.AddressStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressStockRepository extends JpaRepository<AddressStockEntity,Long> {

}
