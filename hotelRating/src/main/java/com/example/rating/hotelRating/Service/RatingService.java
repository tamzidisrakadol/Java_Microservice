package com.example.rating.hotelRating.Service;

import com.example.rating.hotelRating.Model.Rating;

import java.util.List;


public interface RatingService {

    //create
    Rating createRating(Rating rating);

    //get all rating
    List<Rating> getAllRating();

    //get rating-info by  user id
    List<Rating> getRatingByUserId(String userId);

    //get rating-info by  hotel id
    List<Rating> getRatingByHotelId(String hotelId);
}
