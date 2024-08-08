
package com.example.UserService.ExternalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.UserService.model.Rating;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="HOTEL-RATING")
public interface FeignClientRatingService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getAllRatings(@PathVariable("userId") String userId);

    @PostMapping("/ratings")
    Rating setRatingByUserId(@RequestBody Rating rating);
    
}