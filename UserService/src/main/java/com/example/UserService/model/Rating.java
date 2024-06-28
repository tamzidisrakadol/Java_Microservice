package com.example.UserService.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private String RatingID;
    private String userID;
    private String hotelID;
    private int rating;
    private String feedback;

}
