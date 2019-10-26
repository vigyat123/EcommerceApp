package com.assignment.ecommerceApp.mappers;

import com.assignment.ecommerceApp.dto.User;
import com.assignment.ecommerceApp.repositories.UserEntity;

public class UserMapper {

    public static UserEntity map(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }

    public static User map(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return user;
    }
}
