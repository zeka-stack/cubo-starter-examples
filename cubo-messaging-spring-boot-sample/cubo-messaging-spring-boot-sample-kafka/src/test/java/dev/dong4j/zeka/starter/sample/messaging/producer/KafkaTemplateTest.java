package dev.dong4j.zeka.starter.sample.messaging.producer;

import dev.dong4j.zeka.kernel.common.util.ThreadUtils;
import dev.dong4j.zeka.kernel.test.mock.Mock;
import dev.dong4j.zeka.kernel.test.mock.MockConfig;
import dev.dong4j.zeka.kernel.test.mock.TypeKit;
import dev.dong4j.zeka.starter.sample.messaging.Order;
import dev.dong4j.zeka.starter.sample.messaging.Payment;
import dev.dong4j.zeka.starter.sample.messaging.SampleKafkaApplicationTest;
import java.util.List;
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
 * @date 2025.06.26 00:27
 * @since x.x.x
 */
@Slf4j
@TestPropertySource(locations = "classpath:application-producer.yml")
public class KafkaTemplateTest extends SampleKafkaApplicationTest {

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
    void advancedKafkaSend1() {
        // 使用原生API发送
        ProducerRecord<String, Object> record = new ProducerRecord<>("zeka-stack-topic", payment);
        kafkaTemplate.send(record);

        ThreadUtils.join();
    }
}
