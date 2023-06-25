package com.aw.lifetravel.domain.service;

import com.aw.lifetravel.domain.model.entity.Hotel;
import com.aw.lifetravel.domain.model.entity.Plan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlanService {
    List<Plan> getAll();
    Plan getById(Long planId);

    Plan create(Plan savePlan);
    ResponseEntity<?> delete(Long id);

    Plan update(Long id, Plan updatedPlan);
}
