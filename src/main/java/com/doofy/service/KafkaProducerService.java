package com.doofy.service;

public interface KafkaProducerService {
    void createTopic();
    void descripTopic();
    void publish(String topic,String message);
}
