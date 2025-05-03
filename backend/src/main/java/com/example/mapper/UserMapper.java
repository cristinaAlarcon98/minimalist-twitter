package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.model.User;

public class UserMapper {

    public static UserDTO toDto(User user) {

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getFollowing().stream().map(User::getId).toList(),
                user.getFollowers().stream().map(User::getId).toList());
    }
}