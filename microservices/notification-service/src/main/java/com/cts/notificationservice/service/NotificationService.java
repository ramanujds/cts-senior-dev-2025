package com.cts.notificationservice.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {


    @KafkaListener(topics = "order-events", groupId = "my-order-group")
    public void sendNotification(ConsumerRecord<String,String> record){
        log.info("New Message Received {}",record.value());
        // any task you can perform
    }

}
