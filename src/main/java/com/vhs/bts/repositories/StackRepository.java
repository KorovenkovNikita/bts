package com.vhs.bts.repositories;

import com.vhs.bts.entities.StackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<StackEntity, Long> {
}
