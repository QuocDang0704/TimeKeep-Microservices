package com.example.timekeeplogin.repository;

import com.example.timekeeplogin.entity.PermitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface IPermitRepository extends JpaRepository<PermitEntity, Integer> {
    List<PermitEntity> findAllByStatus(Integer status);
}
