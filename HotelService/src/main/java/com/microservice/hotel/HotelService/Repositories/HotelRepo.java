package com.microservice.hotel.HotelService.Repositories;

import com.microservice.hotel.HotelService.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {

}
