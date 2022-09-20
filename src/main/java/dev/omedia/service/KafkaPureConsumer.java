package dev.omedia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaPureConsumer {
    @KafkaListener(topics = "car", groupId = "car-group")
    public void consumeCar(dev.omedia.models.Car car) {
        log.info("received car event " + car);
    }
}
