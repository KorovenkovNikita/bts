package com.vhs.bts.repositories;

import com.vhs.bts.entities.GraphicCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicCardRepository extends JpaRepository<GraphicCardEntity,Long> {
}
