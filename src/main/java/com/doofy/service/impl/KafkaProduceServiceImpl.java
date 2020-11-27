package com.doofy.service.impl;

import com.doofy.producer.KafkaSender;
import com.doofy.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduceServiceImpl implements KafkaProducerService {
    @Autowired
    KafkaSender kafkaProducerUtil;
    @Override
    public void createTopic() {

    }

    @Override
    public void descripTopic() {

    }

    @Override
    public void publish(String topic,String message) {

        kafkaProducerUtil.sendMessage(topic,message);
    }
}
