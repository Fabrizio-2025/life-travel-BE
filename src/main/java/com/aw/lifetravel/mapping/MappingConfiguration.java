package com.aw.lifetravel.mapping;

import com.aw.lifetravel.mapping.mappers.HotelMapper;
import com.aw.lifetravel.mapping.mappers.PlanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("LifeTravelMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public HotelMapper hotelMapper(){
        return new HotelMapper();
    }

    @Bean
    public PlanMapper planMapper(){
        return new PlanMapper();
    }
}
