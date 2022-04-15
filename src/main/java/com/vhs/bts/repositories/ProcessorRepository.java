package com.vhs.bts.repositories;

import com.vhs.bts.entities.ProcessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorRepository extends JpaRepository<ProcessorEntity,Long> {
}