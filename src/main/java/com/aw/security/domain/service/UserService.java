package com.aw.security.domain.service;

import com.aw.security.domain.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long userId);

    User create(User saveUser);

    ResponseEntity<?> delete(Long id);

    User update(Long id, User updatedUser);
}
