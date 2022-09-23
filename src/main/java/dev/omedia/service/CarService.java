package dev.omedia.service;

import dev.omedia.domain.Car;
import dev.omedia.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
//        produce car message / or audit message as you decide
        return carRepository.save(car);
    }

    public Car getCar(Integer id) {
        return carRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Car> getAllCars(){
        return carRepository.findAll();
    }

}
