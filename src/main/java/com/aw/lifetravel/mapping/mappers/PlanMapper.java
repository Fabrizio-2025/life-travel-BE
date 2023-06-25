package com.aw.lifetravel.mapping.mappers;

import com.aw.lifetravel.domain.model.entity.Hotel;
import com.aw.lifetravel.domain.model.entity.Plan;
import com.aw.lifetravel.resource.create.CreateHotelResource;
import com.aw.lifetravel.resource.create.CreatePlanResource;
import com.aw.lifetravel.resource.show.HotelResource;
import com.aw.lifetravel.resource.show.PlanResource;
import com.aw.lifetravel.resource.update.UpdateHotelResource;
import com.aw.lifetravel.resource.update.UpdatePlanResource;
import com.aw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlanMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public PlanResource toResource(Plan planmodel) {
        return mapper.map(planmodel, PlanResource.class);
    }

    public List<PlanResource> toListResource(List<Plan> plans) {
        return mapper.mapList(plans, PlanResource.class);
    }

    public Plan createResourceToModel(CreatePlanResource createPlanResource) {
        return mapper.map(createPlanResource, Plan.class);
    }

    public Plan updateResourceToModel(UpdatePlanResource updatePlanResource) {
        return mapper.map(updatePlanResource, Plan.class);
    }
}
