package com.aw.lifetravel.api.rest;

import com.aw.lifetravel.domain.service.HotelService;
import com.aw.lifetravel.mapping.mappers.HotelMapper;
import com.aw.lifetravel.resource.create.CreateHotelResource;
import com.aw.lifetravel.resource.show.HotelResource;
import com.aw.lifetravel.resource.update.UpdateHotelResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hotels",produces = "application/json")
public class HotelController {
    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    public HotelController(HotelService hotelService,HotelMapper hotelMapper){
        this.hotelService = hotelService;
        this.hotelMapper = hotelMapper;
    }

    @GetMapping("all")
    public List<HotelResource> getAllUser(){
        return hotelMapper.toListResource(hotelService.getAll());
    }

    @GetMapping("{id}")
    public HotelResource getById(@PathVariable long id){
        return hotelMapper.toResource(hotelService.getById(id));
    }

    @PostMapping
    public HotelResource createHotel(@RequestBody CreateHotelResource hotelResource) {
        return hotelMapper.toResource(hotelService.create(hotelMapper.createResourceToModel(hotelResource)));
    }

    @PutMapping("{id}")
    public HotelResource updateHotel(@PathVariable Long id, @RequestBody UpdateHotelResource hotelResource){
        return hotelMapper.toResource(hotelService.update(id,hotelMapper.updateResourceToModel(hotelResource)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id) {
        return hotelService.delete(id);
    }

}
