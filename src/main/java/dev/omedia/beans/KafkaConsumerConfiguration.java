//package dev.omedia.beans;
//
//import dev.omedia.domain.Car;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaConsumerConfiguration {
//
//    @Bean
//    public Map<String, Object> consumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
////        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return props;
//    }
//
//    @Bean(name = "stringConsumer")
//    public ConcurrentKafkaListenerContainerFactory<String, String> stringConsumer() {
//        ConcurrentKafkaListenerContainerFactory<String, String> consumerFactory = new ConcurrentKafkaListenerContainerFactory<>();
//        Map<String, Object> configs = consumerConfigs();
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "string-group");
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        consumerFactory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(configs,
//                new StringDeserializer(),
//                new StringDeserializer()));
//        return consumerFactory;
//    }
//
//    @Bean(name = "carConsumer")
//    public ConcurrentKafkaListenerContainerFactory<String, Car> carConsumer() {
//        ConcurrentKafkaListenerContainerFactory<String, Car> consumerFactory = new ConcurrentKafkaListenerContainerFactory<>();
//        Map<String, Object> configs = consumerConfigs();
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "car-group");
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        DefaultKafkaConsumerFactory<String, Car> stringCarDefaultKafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(configs,
//                new StringDeserializer(),
//                new JsonDeserializer<>(Car.class));
//        consumerFactory.setConsumerFactory(stringCarDefaultKafkaConsumerFactory);
//        return consumerFactory;
//    }
//}
