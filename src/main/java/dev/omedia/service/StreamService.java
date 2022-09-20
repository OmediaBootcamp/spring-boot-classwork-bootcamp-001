package dev.omedia.service;

import dev.omedia.domain.Car;
import dev.omedia.models.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.function.Consumer;

@Service
@Slf4j
public class StreamService {

    private final StreamBridge streamBridge;

    public StreamService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostConstruct
    public void postConst() {
        produceCar(new Car(15));
        Employee employee =
                Employee.newBuilder()
                        .setId(12)
                        .setFirstName("giorgi").setLastName("odis").setAge(14).build();
        producerEmployee(employee);
    }

    public void produceCar(Car car) {
        streamBridge.send("carBinding-out-0", car);
    }

    @Bean
    public Consumer<Message<Car>> carBinding() {
        return msg -> log.info("received car message " + msg);
    }

    public void producerEmployee(Employee employee) {
        streamBridge.send("employeeBinding-out-0", employee);
    }

    @Bean
    public Consumer<Message<Employee>> employeeBinding() {
        return msg -> log.info("received Employee message " + msg);
    }

}
