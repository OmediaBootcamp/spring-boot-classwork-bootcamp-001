//package dev.omedia.beans;
//
//import dev.omedia.domain.Car;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaProducerConfiguration {
//
//    @Bean
//    public Map<String, Object> producerConfigsForJson() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // StringSerializer
//        return props;
//    }
//
////    @Bean
////    public KafkaTemplate<String, String> stringTemplate() {
////        Map<String, Object> configs = producerConfigsForJson();
////        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // StringSerializer
////        return new KafkaTemplate<>(
////                new DefaultKafkaProducerFactory<>(configs)
////        );
////    }
////
////    @Bean
////    public KafkaTemplate<String, Car> carTemplate() {
////        Map<String, Object> configs = producerConfigsForJson();
////        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // StringSerializer
////        return new KafkaTemplate<>(
////                new DefaultKafkaProducerFactory<>(configs)
////        );
////    }
//
//    @Bean
//    public KafkaTemplate<String, Object> objectTemplate() {
//        Map<String, Object> configs = producerConfigsForJson();
//        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // StringSerializer
//        return new KafkaTemplate<>(
//                new DefaultKafkaProducerFactory<>(configs)
//        );
//    }
//}
