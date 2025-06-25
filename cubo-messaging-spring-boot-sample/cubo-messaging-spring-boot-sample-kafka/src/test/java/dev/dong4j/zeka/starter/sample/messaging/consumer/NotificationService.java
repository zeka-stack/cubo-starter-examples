package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    @MessagingListener(
        topic = "notifications",
        groupId = "notification-group"
    )
    public void sendNotification(
        Order order,
        @Header("notification-type") String type,
        @Header("priority") int priority
    ) {
        log.warn("High priority notification: {}", order.getId());
        log.warn("High priority notification: {}", type);
        log.warn("High priority notification: {}", priority);
    }
}
