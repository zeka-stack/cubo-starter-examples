package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BatchProcessor {

    /**
     * UnifiedMessageListener(
     * topic = "custom-topic",          // 必填：监听的主题
     * groupId = "custom-group",        // 必填：消费者组ID
     * type = MQType.ROCKETMQ,          // 可选：指定MQ类型（默认自动检测）
     * batch = false,                   // 可选：是否批量消费（默认false）
     * concurrency = "3-5",             // 可选：并发消费者数量
     * condition = "",                  // 可选：SpEL条件表达式过滤消息
     * errorHandler = "customErrorHandler" // 可选：自定义错误处理方法
     * )
     *
     * @param orders 订单
     */
    @MessagingListener(
        topic = "metrics",
        groupId = "metrics-group"
    )
    public void processMetricsBatch(List<Order> orders) {
        System.out.println("Processing batch of " + orders.size() + " metrics");
    }

}
