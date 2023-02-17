package com.clubadministrator.clubAdmin.repository;

import com.clubadministrator.clubAdmin.entities.PlanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity,Long> {
    Page<PlanEntity> findAllByNameOrPrice(String name, Long price, Pageable pageable);

}
