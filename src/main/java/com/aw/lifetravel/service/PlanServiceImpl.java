package com.aw.lifetravel.service;


import com.aw.lifetravel.domain.model.entity.Plan;
import com.aw.lifetravel.domain.persistence.PlanRepository;
import com.aw.lifetravel.domain.service.PlanService;
import com.aw.shared.exception.ResourceNotFoundException;
import com.aw.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class PlanServiceImpl implements PlanService {
    private static final String entity = "Plan";
    private final PlanRepository planRepository;
    private final Validator validator;

    public PlanServiceImpl(PlanRepository planRepository,Validator validator){
        this.planRepository = planRepository;
        this.validator = validator;
    }

    @Override
    public List<Plan> getAll(){
        return planRepository.findAll();
    }

    @Override
    public Plan getById(Long planId) {
        return planRepository.findByPlanId(planId).orElseThrow(() -> new ResourceNotFoundException(entity, planId));
    }

    @Override
    public Plan create(Plan plan) {
        Set<ConstraintViolation<Plan>> violations = validator.validate(plan);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        return planRepository.save(plan);
    }

    public Plan update(Long planId, Plan updatedPlan) {
        Set<ConstraintViolation<Plan>> violations = validator.validate(updatedPlan);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        if(!planRepository.existsByPlanId(planId))
            throw new ResourceValidationException("User does not exist.");

        Plan existingUser = planRepository.findByPlanId(planId).get();



        return planRepository.save(existingUser
                .withName(updatedPlan.getName())
                .withDetails(updatedPlan.getDetails())
                .withPrice(updatedPlan.getPrice())
                .withDays(updatedPlan.getDays()));
    }

    @Override
    public ResponseEntity<?> delete(Long planId) {
        return planRepository.findByPlanId(planId).map(plan -> {
            planRepository.delete(plan);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entity, planId));
    }
}
