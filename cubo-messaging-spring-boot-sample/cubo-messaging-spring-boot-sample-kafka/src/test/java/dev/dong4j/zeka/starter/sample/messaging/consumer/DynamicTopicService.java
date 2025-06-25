package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DynamicTopicService {

    @Value("${app.topics.order}")
    private String orderTopic;

    @MessagingListener(
        topic = "#{@topicResolver.getOrderTopic()}",
        groupId = "order-group"
    )
    public void processOrder(Order order) {
        log.info("{}", order);
    }

}
