package com.aw.security.mapping.mappers;

import com.aw.lifetravel.resource.create.CreateUserResource;
import com.aw.lifetravel.resource.show.UserResource;
import com.aw.lifetravel.resource.update.UpdateUserResource;
import com.aw.security.domain.model.entity.User;
import com.aw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User usermodel) {
        return mapper.map(usermodel, UserResource.class);
    }

    public List<UserResource> toListResource(List<User> stores) {
        return mapper.mapList(stores, UserResource.class);
    }

    public User createResourceToModel(CreateUserResource createProductResource) {
        return mapper.map(createProductResource, User.class);
    }

    public User updateResourceToModel(UpdateUserResource updateProductResource) {
        return mapper.map(updateProductResource, User.class);
    }
}
