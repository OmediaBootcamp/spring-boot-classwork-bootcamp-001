package dev.omedia.service;

import dev.omedia.domain.Car;
import dev.omedia.messaging.KafkaPureProducer;
import dev.omedia.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final KafkaPureProducer kafkaPureProducer;

    public CarService(CarRepository carRepository, KafkaPureProducer kafkaPureProducer) {
        this.carRepository = carRepository;
        this.kafkaPureProducer = kafkaPureProducer;
    }

    public Car createCar(Car car) {
        kafkaPureProducer.produceCar(car);
        return carRepository.save(car);
    }

    public Car getCar(Integer id) {
        return carRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Car> getAllCars(){
        return carRepository.findAll();
    }

}
