package com.aw.lifetravel.domain.persistence;

import com.aw.lifetravel.domain.model.entity.Hotel;
import com.aw.lifetravel.domain.model.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findAll();
    Optional<Plan> findByPlanId(Long planId);
    Boolean existsByPlanId(Long planId);
}
