package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.messaging.context.MessagingContext;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryService {

    @MessagingListener(
        topic = "inventory-updates",
        groupId = "inventory-group"
    )
    public void updateInventory(Order order, MessagingContext context) {
        log.info("Updating inventory for product: {}", order.getAmount());
        log.info("MQ type: {}", context.getMessagingType());
        log.info("Topic: {}", context.getTopic());

    }
}
