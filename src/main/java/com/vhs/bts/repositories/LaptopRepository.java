package com.vhs.bts.repositories;

import com.vhs.bts.entities.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {
    List<LaptopEntity> findAllByCore(String core);
}

