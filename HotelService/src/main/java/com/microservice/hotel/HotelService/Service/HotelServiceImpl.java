package com.microservice.hotel.HotelService.Service;

import com.microservice.hotel.HotelService.Dto.ReviewMessageQueue;
import com.microservice.hotel.HotelService.Exception.ResourceNotFoundException;
import com.microservice.hotel.HotelService.Repositories.HotelRepo;
import com.microservice.hotel.HotelService.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel with given id not found"));
    }

    @Override
    public void updateCompanyReview(ReviewMessageQueue reviewMessageQueue) {
        System.out.println(reviewMessageQueue.getFeedback());
    }
}
