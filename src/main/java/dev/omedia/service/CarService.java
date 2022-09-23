package dev.omedia.service;

import dev.omedia.domain.Car;
import dev.omedia.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import static dev.omedia.service.constant.BindingNames.*;
@Service
public class CarService {
    private final CarRepository carRepository;
    private final StreamBridge bridge;

    @Autowired
    public CarService(CarRepository carRepository, StreamBridge bridge) {
        this.carRepository = carRepository;
        this.bridge = bridge;
    }

    public Car createCar(Car car) {
        bridge.send(CAR_OUT_BINDING, car);
        return carRepository.save(car);
    }

    public Car getCar(String uuid) {
        return carRepository.findByUuid(uuid).orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car update(String uuid, Car car){
        getCar(uuid);
        car.setUuid(uuid);
        return carRepository.save(car);
    }

}
