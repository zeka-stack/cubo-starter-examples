package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.messaging.model.UnifiedMessage;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    @MessagingListener(
        topic = "orders",
        groupId = "order-group"
    )
    public void processOrder(UnifiedMessage message) {
        Order order = (Order) message.getPayload();
        System.out.println("Processing order: " + order.getId());
    }
}
