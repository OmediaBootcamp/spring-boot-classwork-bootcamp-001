package dev.omedia.messaging;

import dev.omedia.domain.Car;
import dev.omedia.domain.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPureProducer {
    private final KafkaTemplate<String, Object> objectKafkaTemplate;

    public KafkaPureProducer(KafkaTemplate<String, Object> objectKafkaTemplate) {
        this.objectKafkaTemplate = objectKafkaTemplate;
    }

    public void produceCar(Car car) {
        objectKafkaTemplate.send("car", car);
    }

    public void produceUser(User user) {
        objectKafkaTemplate.send("user", user);
    }


}
