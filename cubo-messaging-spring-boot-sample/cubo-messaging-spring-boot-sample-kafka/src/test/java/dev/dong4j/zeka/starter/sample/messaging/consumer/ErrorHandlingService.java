package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ErrorHandlingService {

    @MessagingListener(
        topic = "error-prone",
        groupId = "error-group"
        // , errorHandler = "handleProcessingError"
    )
    public void processData(Order order) {

    }

    // 错误处理方法（与监听方法在同一类中）
    public void handleProcessingError(Order order, Exception ex) {
        log.error("Failed to process record: {}", order.getId(), ex);
    }
}
