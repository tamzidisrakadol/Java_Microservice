package com.microservice.hotel.HotelService.Service;

import com.microservice.hotel.HotelService.Dto.ReviewMessageQueue;
import com.microservice.hotel.HotelService.model.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel createHotel(Hotel hotel);

    //get All
    List<Hotel> getAll();

    //get single Hotel
    Hotel getHotelById(String id);

    void updateCompanyReview(ReviewMessageQueue reviewMessageQueue);


}
