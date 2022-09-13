package dev.omedia.controller;

import dev.omedia.domain.Car;
import dev.omedia.repository.CarRepo;
import dev.omedia.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarRepo carRepo;
    private final CarService carService;

    @Autowired
    public CarController(CarRepo carRepo, CarService carService) {
        this.carRepo = carRepo;
        this.carService = carService;
    }

    @PostMapping
    public Car insertCar(@RequestBody Car car){
        return carRepo.insert(car);
    }

    @GetMapping
    public Iterable<Car> getAll(){
        return carService.getAll();
    }
}
