package com.example.UserService.ExternalService;


import com.example.UserService.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081/hotels",value = "Hotel-Service")
public interface FeignClientHotelService {

    @GetMapping("/{hotelId}")
    Hotel getHotelInfo(@PathVariable String hotelId);

}
