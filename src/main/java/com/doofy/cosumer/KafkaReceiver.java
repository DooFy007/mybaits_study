package com.doofy.cosumer;

import com.doofy.constant.KafkaConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {KafkaConstant.TOPIC_DOOFY}, groupId = KafkaConstant.CONSUMER_GROUP_FIRST)
    public void subcribeMessage(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
    }


}
