package com.example.rating.hotelRating.Repository;


import com.example.rating.hotelRating.Model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {


    //custom queries
    //note: the query name should start with findBy
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
