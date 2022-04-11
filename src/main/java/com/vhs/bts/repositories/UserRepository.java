package com.vhs.bts.repositories;

import com.vhs.bts.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllById(long id);
    UserEntity deleteById(long id);
}
