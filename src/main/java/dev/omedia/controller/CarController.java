package dev.omedia.controller;

import dev.omedia.domain.Car;
import dev.omedia.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(Car car) {
        return carService.createCar(car);
    }

    @GetMapping
    public Iterable<Car> getCar() {
        return carService.getAllCars();
    }

    @GetMapping("/{uuid}")
    public Car getCarById(@PathVariable String uuid) {
        return carService.getCar(uuid);
    }
}
