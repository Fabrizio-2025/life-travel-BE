package com.aw.security.mapping;

import com.aw.security.mapping.mappers.UserMapper;
import com.aw.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("SecurityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }
}
