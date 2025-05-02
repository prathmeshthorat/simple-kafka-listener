package com.pst.kafka_listener.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import org.apache.kafka.common.serialization.StringDeserializer;
import com.pst.kafka_listener.model.NotificationRequest;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, NotificationRequest> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);

        // Configure the JsonDeserializer to trust the package containing
        // NotificationRequest
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.pst.kafka_listener.model");
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.pst.kafka_listener.model.NotificationRequest");

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(NotificationRequest.class));
    }

    // Creating a Listener
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NotificationRequest> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, NotificationRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
