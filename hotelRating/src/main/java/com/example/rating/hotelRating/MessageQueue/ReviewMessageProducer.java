package com.example.rating.hotelRating.MessageQueue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.rating.hotelRating.Dto.ReviewMessageQueue;
import com.example.rating.hotelRating.Model.Rating;

@Service
public class ReviewMessageProducer {
    
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Rating rating){
        ReviewMessageQueue reviewMessageQueue = new ReviewMessageQueue();
        reviewMessageQueue.setId(rating.getId());
        reviewMessageQueue.setHotelId(rating.getHotelId());
        reviewMessageQueue.setFeedback(rating.getFeedback());
        reviewMessageQueue.setRating(rating.getRating());
        reviewMessageQueue.setUserId(rating.getUserId());

        rabbitTemplate.convertAndSend("companyRatingQueue",reviewMessageQueue);
    }

    
}
