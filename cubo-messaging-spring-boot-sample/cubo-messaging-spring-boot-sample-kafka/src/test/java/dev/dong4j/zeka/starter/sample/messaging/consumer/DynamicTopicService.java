package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DynamicTopicService {

    @MessagingListener(
        topic = "${app.topics.order:}",
        groupId = "order-group"
    )
    public void processOrder(Order order) {
        log.info("{}", order);
    }

}
