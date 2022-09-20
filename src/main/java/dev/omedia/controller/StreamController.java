package dev.omedia.controller;

import dev.omedia.domain.Car;
import dev.omedia.service.StreamService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamController {
    private final StreamService service;

    public StreamController(StreamService service) {
        this.service = service;
    }

    @PostMapping("/car/{id}")
    public void postCar(@PathVariable int id) {
        service.produceCar(new Car(id));
    }


}
