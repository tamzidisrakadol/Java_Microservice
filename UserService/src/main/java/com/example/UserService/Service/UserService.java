package com.example.UserService.Service;

import com.example.UserService.model.User;

import java.util.List;

public interface UserService {

    //create user
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get User by id
    User getUserById(String userId);
}
