package com.example.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            groupId = "group-id-json",
            topics = "test-topic")
    void receivedMessage(String message) {
        logger.info("Message Received using Kafka listener " + message);
    }
}