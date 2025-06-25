package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import dev.dong4j.zeka.starter.messaging.enums.MessagingType;
import dev.dong4j.zeka.starter.sample.messaging.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @MessagingListener(
        topic = "payments",
        groupId = "payment-group",
        type = MessagingType.KAFKA
    )
    public void handlePayment(Payment payment) {
        // 直接接收反序列化的支付对象
        System.out.println("Processing payment: " + payment.getId());
    }
}
