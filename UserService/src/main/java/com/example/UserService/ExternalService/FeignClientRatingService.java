
package com.example.UserService.ExternalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.UserService.model.Rating;

@FeignClient(value ="HOTEL-RATING",url = "http://localhost:8083")
public interface FeignClientRatingService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getAllRatings(@PathVariable("userId") String userId);
    
}