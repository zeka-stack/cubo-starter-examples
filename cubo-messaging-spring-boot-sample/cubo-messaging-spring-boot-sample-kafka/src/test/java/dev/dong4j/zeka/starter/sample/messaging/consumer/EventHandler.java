package dev.dong4j.zeka.starter.sample.messaging.consumer;

import dev.dong4j.zeka.starter.messaging.annotation.MessagingListener;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class EventHandler {

    @MessagingListener(
        topic = "events",
        groupId = "event-group"
        // , condition = "headers['event-type'] == 'USER_REGISTERED'"
    )
    public void test(SecurityProperties.User user) {
        System.out.println("New user registered: " + user.getName());
    }

}
