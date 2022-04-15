package com.vhs.bts.repositories;

import com.vhs.bts.entities.ScreenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity,Long> {
}
