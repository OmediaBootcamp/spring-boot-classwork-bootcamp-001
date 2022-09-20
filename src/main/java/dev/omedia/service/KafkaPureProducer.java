package dev.omedia.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class KafkaPureProducer {

    private final KafkaTemplate<String, Object> objectKafkaTemplate;

    public KafkaPureProducer(KafkaTemplate<String, Object> objectKafkaTemplate) {
        this.objectKafkaTemplate = objectKafkaTemplate;
    }

    @PostConstruct
    public void postConst() {
        produceCar(new dev.omedia.models.Car(15, 2001));
    }

    public void produceCar(dev.omedia.models.Car car) {
        objectKafkaTemplate.send("car", car);
    }


}
