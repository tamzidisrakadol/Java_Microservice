
package com.microservice.hotel.HotelService.Dto;

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
    
    @Id
    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    
}