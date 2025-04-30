package com.pst.kafka_listener.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @KafkaListener(topics = "test-topic", groupId = "group_id_0", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("message = group_id_0 = " + message);
    }

    @KafkaListener(topics = "test-topic", groupId = "group_id_1", containerFactory = "kafkaListenerContainerFactory")
    public void process(String message) {
        // Print statement
        System.out.println("message for group_id_1 = " + message);
    }
}
