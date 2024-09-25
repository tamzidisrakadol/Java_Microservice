package com.microservice.hotel.HotelService.MessageQueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.microservice.hotel.HotelService.Dto.ReviewMessageQueue;
import com.microservice.hotel.HotelService.Service.HotelService;

@Service
public class ReviewMessageConsumer {

    private final HotelService hotelService;

    public ReviewMessageConsumer(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessageQueue reviewMessageQueue){
        hotelService.updateCompanyReview(reviewMessageQueue);
    }


    
}
