package dev.omedia.messaging;

import dev.omedia.domain.Car;
import dev.omedia.domain.User;
import dev.omedia.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class EventListener {

    private final AuditService service;

    @Autowired
    public EventListener(AuditService service) {
        this.service = service;
    }

    @Bean
    public Consumer<Message<Car>> carBinding() {
        return carMessage -> service.createAudit(carMessage.getPayload());
    }

    @Bean
    public Consumer<Message<User>> userBinding() {
        return userMessage -> service.createAudit(userMessage.getPayload());
    }
}
