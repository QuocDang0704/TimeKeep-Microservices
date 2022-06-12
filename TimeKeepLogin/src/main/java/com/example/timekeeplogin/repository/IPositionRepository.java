package com.example.timekeeplogin.repository;

import com.example.timekeeplogin.entity.PositionEntity;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface IPositionRepository extends JpaRepository<PositionEntity, Integer> {
    Optional<PositionEntity> findByRole(Integer role);

    PositionEntity getById(Integer id);
}
