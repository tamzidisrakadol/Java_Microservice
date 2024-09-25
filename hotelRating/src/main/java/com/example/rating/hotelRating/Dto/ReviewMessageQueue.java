
package com.example.rating.hotelRating.Dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewMessageQueue {
    
    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    
}