package dev.omedia.messaging;

import dev.omedia.domain.Car;
import dev.omedia.domain.User;
import dev.omedia.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaPureConsumer {
    private final AuditService auditService;

    public KafkaPureConsumer(AuditService auditService) {
        this.auditService = auditService;
    }

    //  Override the group.id property for the consumer factory with this value for this listener only.
    @KafkaListener(topics = "car", groupId = "car-group")
    public void consumeCar(Car car) {
        log.info("received car event " + car);
        auditService.createAudit(car);
    }
    @KafkaListener(topics = "user", groupId = "user-group")
    public void consumeUser(User user) {
        log.info("received user event " + user);
        auditService.createAudit(user);
    }
}
