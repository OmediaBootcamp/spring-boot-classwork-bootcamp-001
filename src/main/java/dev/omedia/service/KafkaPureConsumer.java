package dev.omedia.service;

import dev.omedia.domain.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaPureConsumer {
//
//    @KafkaListener(topics = "string", groupId = "string-group", containerFactory =  "stringConsumer")
//    public void consumeString(String word) {
//        log.info("received string event " + word);
//    }
//  Override the group.id property for the consumer factory with this value for this listener only.
    @KafkaListener(topics = "car", groupId = "car-group")
    public void consumeCar(Car car) {
        log.info("received car event " + car);
    }
}
