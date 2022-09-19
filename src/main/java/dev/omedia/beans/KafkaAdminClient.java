//package dev.omedia.beans;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaAdminClient {
//
//    @Bean
//    public KafkaAdmin kafkaAdminConfig(){
//        Map<String, Object> configs = new HashMap<>();
//        String kafkaServer = "127.0.0.1:29092";
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public NewTopic carTopic(){
//        return new NewTopic("car", 1, (short) 1);
//    }
//
//    @Bean
//    public NewTopic transactionTopic(){
//        return new NewTopic("transaction", 1, (short) 1);
//    }
//
//    @Bean
//    public NewTopic stringTopic(){
//        return new NewTopic("string", 1, (short) 1);
//    }
//}
