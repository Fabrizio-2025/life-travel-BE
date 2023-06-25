package com.aw.security.service;

import com.aw.security.domain.model.entity.User;
import com.aw.security.domain.persistence.UserRepository;
import com.aw.security.domain.service.UserService;
import com.aw.shared.exception.ResourceNotFoundException;
import com.aw.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final String entity = "User";
    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository,Validator validator){
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException(entity, userId));
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        return userRepository.save(user);
    }

    public User update(Long userId, User updatedUser) {
        Set<ConstraintViolation<User>> violations = validator.validate(updatedUser);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        if(!userRepository.existsByUserId(userId))
            throw new ResourceValidationException("User does not exist.");

        User existingUser = userRepository.findByUserId(userId).get();



        return userRepository.save(existingUser
                .withName(updatedUser.getName())
                .withLastname(updatedUser.getLastname())
                .withWalletNum(updatedUser.getWalletNum())
                .withWalletCredit(updatedUser.getWalletCredit()));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findByUserId(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entity, userId));
    }
}
