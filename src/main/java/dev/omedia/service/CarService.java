package dev.omedia.service;

import dev.omedia.models.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class CarService {
    public final Set<Car> mockCarSet = new HashSet<>();

    @PostConstruct
    public void init() {
        mockCarSet.add(new Car(1, "BMW"));
        mockCarSet.add(new Car(2, "Mercedes"));
        mockCarSet.add(new Car(3, "MAZDA"));
        mockCarSet.add(new Car(3, "VOLVO"));
        mockCarSet.add(new Car(4, "TESLA"));
    }

    public Car createCar(Car car) {
        return car == null ? null : mockCarSet.add(car) ? car : null;
    }

    public Car getCar(int id) {
        return mockCarSet.stream().filter(it -> it.getId() == id)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Car updateCar(int id, String model) {

        Car car = getCar(id);

        car.setModel(model);
        return car;
    }
}
