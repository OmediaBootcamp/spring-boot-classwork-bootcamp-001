package dev.omedia.controller;

import dev.omedia.domain.Car;
import dev.omedia.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Autowired
    private CarRepository repository;

    @LocalServerPort
    private int port;

    @Test
    void createCar() {
        Car car = new Car("1","ragac",1999);
        ResponseEntity<Car> carResponseEntity = template
                .postForEntity("http://localhost:"+port+"/car", car, Car.class);
        Assertions.assertEquals(HttpStatus.CREATED, carResponseEntity.getStatusCode());
        Assertions.assertEquals(car,carResponseEntity.getBody());
    }

    @Test
    void getCar() {
    }

    @Test
    void getCarById() {
    }
}