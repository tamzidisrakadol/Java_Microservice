package com.example.UserService.Controller;


import com.example.UserService.Service.UserService;
import com.example.UserService.model.Rating;
import com.example.UserService.model.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    //create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //get Single user by id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }


    //get all User
    @GetMapping
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallbackMethod")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }


    //Note: the error method returns the dummy user.
    public ResponseEntity<User> ratingHotelFallbackMethod(Exception exception){
        System.out.println("error Message : "+exception.getMessage());
        User errorUser = User.builder()
        .email("@Gmail.com")
        .name("dummyName")
        .userid("dummy_ID")
        .address("dummyAddress")
        .build();
        return ResponseEntity.ok(errorUser);
    }


    @PostMapping("/setRating/{userId}")
    public ResponseEntity<User> setRatingByUser(@PathVariable String userId,@RequestBody Rating rating){
        User user = userService.setRatingByUserId(userId,rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    } 
}
