package dev.dong4j.zeka.starter.sample.messaging;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @KafkaListener(topics = "zeka-stack-topic", groupId = "demo")
    public void listen(ConsumerRecord<String, Object> record) {
        log.info("Key: {}, Value: {}", record.key(), record.value());
    }
}
