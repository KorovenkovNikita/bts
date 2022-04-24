package com.vhs.bts.repositories;

import com.vhs.bts.entities.BucketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends JpaRepository<BucketEntity,Long> {

}
