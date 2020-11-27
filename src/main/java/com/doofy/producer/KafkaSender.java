package com.doofy.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class KafkaSender {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {

        log.info("kafka生产者发布:topic {}, message {}", topic, message);
        kafkaTemplate.send(topic, message);
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata) {
                long offset = recordMetadata.offset();
                log.info("offset {}, topic {}, partition{}", offset, recordMetadata.topic(), recordMetadata.partition());
            }
            @Override
            public void onError(ProducerRecord<String, String> producerRecord, Exception exception) {
                log.info("kafka消息发布异常 e {}", exception);
                log.info("key {} value {}, topic {}, partition{}", producerRecord.key(), producerRecord.value(), producerRecord.topic(), producerRecord.partition());
            }
        });
    }



}
