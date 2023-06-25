package com.aw.lifetravel.domain.persistence;

import com.aw.lifetravel.domain.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAll();
    Optional<Hotel> findByHotelId(Long hotelId);
    Boolean existsByHotelId(Long hotelId);
}
