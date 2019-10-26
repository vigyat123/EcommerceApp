package com.assignment.ecommerceApp.services;

import com.assignment.ecommerceApp.dto.User;
import com.assignment.ecommerceApp.mappers.UserMapper;
import com.assignment.ecommerceApp.repositories.UserEntity;
import com.assignment.ecommerceApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(final User user) {
        UserEntity userEntity = UserMapper.map(user);
        userRepository.save(userEntity);
    }
}
