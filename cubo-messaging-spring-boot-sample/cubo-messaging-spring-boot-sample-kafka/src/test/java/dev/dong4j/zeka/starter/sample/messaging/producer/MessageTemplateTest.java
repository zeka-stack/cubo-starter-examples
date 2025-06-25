package dev.dong4j.zeka.starter.sample.messaging.producer;

import dev.dong4j.zeka.kernel.test.mock.Mock;
import dev.dong4j.zeka.kernel.test.mock.MockConfig;
import dev.dong4j.zeka.kernel.test.mock.TypeKit;
import dev.dong4j.zeka.starter.messaging.enums.MessagingType;
import dev.dong4j.zeka.starter.messaging.model.UnifiedMessage;
import dev.dong4j.zeka.starter.messaging.template.MessagingTemplate;
import dev.dong4j.zeka.starter.messaging.template.model.MessageKey;
import dev.dong4j.zeka.starter.messaging.template.model.SendResult;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import dev.dong4j.zeka.starter.sample.messaging.Payment;
import dev.dong4j.zeka.starter.sample.messaging.SampleKafkaApplicationTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.TestPropertySource;

/**
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2025.06.25 23:46
 * @since x.x.x
 */
@Slf4j
@TestPropertySource(locations = "classpath:application-producer.yml")
public class MessageTemplateTest extends SampleKafkaApplicationTest {

    @Resource
    private MessagingTemplate messageTemplate;
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;
    private Order order;
    private List<Order> orders;
    private Payment payment;

    @BeforeEach
    void init() {
        order = Mock.mock(Order.class);
        MockConfig config = new MockConfig();
        config.sizeRange(10, 100);
        orders = Mock.mock(new TypeKit<List<Order>>() {
        });
        payment = Mock.mock(Payment.class);
    }


    @Test
    void test_sendSync_1() throws Exception {

        // 创建统一消息
        UnifiedMessage message = new UnifiedMessage("orders", order)
            .withKey(MessageKey.of(order.getId()))  // 设置消息键
            .addHeader("event-type", "ORDER_CREATED");  // 添加消息头

        // 同步发送消息
        SendResult result = messageTemplate.sendSync(message);

        log.info("消息发送成功: {}", result.getMessageId());
    }

    @Test
    void test_sendSync_2() throws Exception {

        UnifiedMessage message = new UnifiedMessage("payments", payment)
            .withKey(MessageKey.of(payment.getId()))
            .addHeader("payment-status", "SUCCESS");

        SendResult result = messageTemplate.sendSync(message);
        log.info("Payment message sent to {}", result.getTopic());
    }

    @Test
    void test_sendAsync_1() throws Exception {

        UnifiedMessage message = new UnifiedMessage("inventory-updates", order);
        CompletableFuture<SendResult> future = messageTemplate.sendAsync(message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Async send failed for inventory update: {}", order.getId(), ex);
            } else {
                log.debug("Inventory update sent: {}", result.getMessageId());
            }
        });
    }

    @Test
    void test_sendOneWay() {

        UnifiedMessage message = new UnifiedMessage("notifications", order);
        // 不等待确认的直接发送
        messageTemplate.sendOneWay(message);
        log.debug("Notification sent: {}", order.getId());
    }

    @Test
    void sendToKafka() {
        UnifiedMessage message = new UnifiedMessage("events", order);

        // 明确指定使用Kafka发送
        SendResult result = messageTemplate.forType(MessagingType.KAFKA).sendSync(message);

        log.info("Event sent via Kafka: {}", result.getMessageId());
    }

    @Test
    void advancedKafkaSend1() {
        // 使用原生API发送
        ProducerRecord<String, Object> record = new ProducerRecord<>("custom-topic", payment);
        kafkaTemplate.send(record);

        // 或者使用原生API的高级特性
        kafkaTemplate.executeInTransaction(template -> {
            template.send("topic1", payment);
            template.send("topic2", order);
            return true;
        });
    }

    @Test
    void advancedKafkaSend2() {
        // 获取原生的KafkaTemplate
        KafkaTemplate<String, Object> kafkaTemplate = messageTemplate.getNativeTemplate(MessagingType.KAFKA, KafkaTemplate.class);

        // 使用原生API发送
        ProducerRecord<String, Object> record = new ProducerRecord<>("custom-topic", payment);
        kafkaTemplate.send(record);

        // 或者使用原生API的高级特性
        kafkaTemplate.executeInTransaction(template -> {
            template.send("topic1", payment);
            template.send("topic2", order);
            return true;
        });
    }

    @Test
    void batchSendOrders() {
        List<CompletableFuture<SendResult>> futures = new ArrayList<>();

        for (Order order : orders) {
            UnifiedMessage message = new UnifiedMessage("orders", order);
            futures.add(messageTemplate.sendAsync(message));
        }

        // 等待所有发送完成
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
            .exceptionally(ex -> {
                log.error("Batch send completed with errors", ex);
                return null;
            })
            .thenRun(() -> log.info("Batch of {} orders sent successfully", orders.size()));
    }
}
