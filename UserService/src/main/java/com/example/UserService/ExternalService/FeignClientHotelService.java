package com.example.UserService.ExternalService;


import com.example.UserService.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="HOTEL-SERVICE")
public interface FeignClientHotelService {

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotelInfo(@PathVariable String hotelId);

}
