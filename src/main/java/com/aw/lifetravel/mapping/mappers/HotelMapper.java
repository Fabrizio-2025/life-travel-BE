package com.aw.lifetravel.mapping.mappers;

import com.aw.lifetravel.domain.model.entity.Hotel;
import com.aw.lifetravel.resource.create.CreateHotelResource;
import com.aw.lifetravel.resource.show.HotelResource;
import com.aw.lifetravel.resource.update.UpdateHotelResource;
import com.aw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HotelMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public HotelResource toResource(Hotel hotelmodel) {
        return mapper.map(hotelmodel, HotelResource.class);
    }

    public List<HotelResource> toListResource(List<Hotel> hotels) {
        return mapper.mapList(hotels, HotelResource.class);
    }

    public Hotel createResourceToModel(CreateHotelResource createHotelResource) {
        return mapper.map(createHotelResource, Hotel.class);
    }

    public Hotel updateResourceToModel(UpdateHotelResource updateHotelResource) {
        return mapper.map(updateHotelResource, Hotel.class);
    }
}
