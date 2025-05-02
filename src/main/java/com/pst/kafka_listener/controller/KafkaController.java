package com.pst.kafka_listener.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pst.kafka_listener.model.NotificationRequest;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class KafkaController {

    private static final String TOPIC = "test-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/kafka/publish")
    public String postMethodName(@RequestBody NotificationRequest entity) {
        kafkaTemplate.send(TOPIC, entity);
        System.out.println("Message sent to Kafka topic: " + TOPIC + " with value: " + entity);
        return ResponseEntity.ok().body(entity.getPayload() + " sent to topic " + TOPIC)
                .toString();
    }

}
