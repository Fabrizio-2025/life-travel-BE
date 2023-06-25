package com.aw.lifetravel.service;

import com.aw.lifetravel.domain.model.entity.Hotel;
import com.aw.lifetravel.domain.persistence.HotelRepository;
import com.aw.lifetravel.domain.service.HotelService;
import com.aw.shared.exception.ResourceNotFoundException;
import com.aw.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {
    private static final String entity = "Hotel";
    private final HotelRepository hotelRepository;
    private final Validator validator;

    public HotelServiceImpl(HotelRepository hotelRepository,Validator validator){
        this.hotelRepository = hotelRepository;
        this.validator = validator;
    }

    @Override
    public List<Hotel> getAll(){
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(Long hotelId) {
        return hotelRepository.findByHotelId(hotelId).orElseThrow(() -> new ResourceNotFoundException(entity, hotelId));
    }

    @Override
    public Hotel create(Hotel hotel) {
        Set<ConstraintViolation<Hotel>> violations = validator.validate(hotel);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        return hotelRepository.save(hotel);
    }

    public Hotel update(Long hotelId, Hotel updatedHotel) {
        Set<ConstraintViolation<Hotel>> violations = validator.validate(updatedHotel);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        if(!hotelRepository.existsByHotelId(hotelId))
            throw new ResourceValidationException("User does not exist.");

        Hotel existingUser = hotelRepository.findByHotelId(hotelId).get();



        return hotelRepository.save(existingUser
                .withName(updatedHotel.getName())
                .withDetails(updatedHotel.getDetails())
                .withPrice(updatedHotel.getPrice())
                .withStartDate(updatedHotel.getStartDate())
                .withEndDate(updatedHotel.getEndDate()));
    }

    @Override
    public ResponseEntity<?> delete(Long hotelId) {
        return hotelRepository.findByHotelId(hotelId).map(hotel -> {
            hotelRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entity, hotelId));
    }
}
