package com.aw.lifetravel.domain.service;

import com.aw.lifetravel.domain.model.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();

    Hotel getById(Long hotelId);

    Hotel create(Hotel saveHotel);

    ResponseEntity<?> delete(Long id);

    Hotel update(Long id, Hotel updatedHotel);
}
