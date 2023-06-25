package com.aw.lifetravel.api.rest;

import com.aw.lifetravel.domain.service.HotelService;
import com.aw.lifetravel.domain.service.PlanService;
import com.aw.lifetravel.mapping.mappers.HotelMapper;
import com.aw.lifetravel.mapping.mappers.PlanMapper;
import com.aw.lifetravel.resource.create.CreateHotelResource;
import com.aw.lifetravel.resource.create.CreatePlanResource;
import com.aw.lifetravel.resource.show.HotelResource;
import com.aw.lifetravel.resource.show.PlanResource;
import com.aw.lifetravel.resource.update.UpdateHotelResource;
import com.aw.lifetravel.resource.update.UpdatePlanResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/plans",produces = "application/json")
public class PlanController {
    private final PlanService planService;
    private final PlanMapper planMapper;

    public PlanController(PlanService planService,PlanMapper planMapper){
        this.planService = planService;
        this.planMapper = planMapper;
    }

    @GetMapping("all")
    public List<PlanResource> getAllUser(){
        return planMapper.toListResource(planService.getAll());
    }

    @GetMapping("{id}")
    public PlanResource getById(@PathVariable long id){
        return planMapper.toResource(planService.getById(id));
    }

    @PostMapping
    public PlanResource createPlan(@RequestBody CreatePlanResource planResource) {
        return planMapper.toResource(planService.create(planMapper.createResourceToModel(planResource)));
    }

    @PutMapping("{id}")
    public PlanResource updatePlan(@PathVariable Long id, @RequestBody UpdatePlanResource planResource){
        return planMapper.toResource(planService.update(id,planMapper.updateResourceToModel(planResource)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePlan(@PathVariable Long id) {
        return planService.delete(id);
    }

}
