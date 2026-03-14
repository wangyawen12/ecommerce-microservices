package com.example.notificationservice.service;

import com.example.notificationservice.event.OrderPlacedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "order-placed-v2", groupId = "notification-group")
    public void handleOrderPlaced(OrderPlacedEvent event) {
        System.out.println("Received OrderPlacedEvent from Kafka: " + event);
    }
}