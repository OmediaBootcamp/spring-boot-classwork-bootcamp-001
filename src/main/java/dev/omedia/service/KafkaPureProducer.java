package dev.omedia.service;

import dev.omedia.domain.Car;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class KafkaPureProducer {


//    private final KafkaTemplate<String, String> stringKafkaTemplate;
//    private final KafkaTemplate<String, Car> carKafkaTemplate;
    private final KafkaTemplate<String, Object> objectKafkaTemplate;
//
//    @Autowired
//    public KafkaPureProducer(KafkaTemplate<String, String> stringKafkaTemplate, KafkaTemplate<String, Car> carKafkaTemplate) {
//        this.stringKafkaTemplate = stringKafkaTemplate;
//        this.carKafkaTemplate = carKafkaTemplate;
//    }

    public KafkaPureProducer(KafkaTemplate<String, Object> objectKafkaTemplate) {
        this.objectKafkaTemplate = objectKafkaTemplate;
    }

    @PostConstruct
    public void postConst() {
//        produceString("string sent");
        produceCar(new Car(15));
    }

    public void produceString(String word) {
        objectKafkaTemplate.send("string", word);
    }

    public void produceCar(Car car) {
        objectKafkaTemplate.send("car", car);
    }


}
