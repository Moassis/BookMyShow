package com.example.Book_my_show_backend.Service;

import com.example.Book_my_show_backend.Dtos.UserRequestDto;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto) {

        // Converted the userRequestDto to UserEntity
        UserEntity userEntity = UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile())
                .build();

        try {
            userRepository.save(userEntity);

        } catch (Exception e) {
            return "user couldnt be added";
        }
        return "User added sucessfully";
    }

    public UserEntity getUserByName(String name) {
        UserEntity user = userRepository.findByName(name);
        return user;
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }
}
