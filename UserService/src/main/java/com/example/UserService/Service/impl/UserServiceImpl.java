package com.example.UserService.Service.impl;

import com.example.UserService.ExternalService.FeignClientHotelService;
import com.example.UserService.ExternalService.FeignClientRatingService;
import com.example.UserService.Repository.UserRepository;
import com.example.UserService.Service.UserService;
import com.example.UserService.model.Hotel;
import com.example.UserService.model.Rating;
import com.example.UserService.model.User;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FeignClientRatingService fRatingService;

    @Autowired
    FeignClientHotelService feignClientHotelService;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserid(randomUserId);
        return userRepository.save(user);
    }

    //show all user with rating and hotel
    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();

        //iterate through the list and set the rating by user id
        for (User user : users){
            List<Rating> ratingList = getRatingsByUserInfo(user);
            user.setRatingList(ratingList);
        }
        return users;
    }

    //show user info by User id
    @Override
    public User getUserById(String userId) {
        //get the userInfo
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given id is not found on server"));
        List<Rating> newRatingList = getRatingsByUserInfo(user);
        user.setRatingList(newRatingList);
        return user;
    }

    //show the ratings and hotel by user object
    private List<Rating> getRatingsByUserInfo(User user) {
        List<Rating> ratingList = fRatingService.getAllRatings(user.getUserid());
        List<Rating> newRatingList = ratingList.stream().peek(rating -> {
            Hotel hotel = feignClientHotelService.getHotelInfo(rating.getHotelId());
            rating.setHotel(hotel);
        }).toList();
        return newRatingList;
    }


    //set the rating by User id
    @Override
    public User setRatingByUserId(String userId,Rating rating) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given id is not found on server"));
        rating.setUserId(userId);
        fRatingService.setRatingByUserId(rating);
        List<Rating> existingRatingList = getRatingsByUserInfo(user);
        user.setRatingList(existingRatingList);
        return user;
    }
}
