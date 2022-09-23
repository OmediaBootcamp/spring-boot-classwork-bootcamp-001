package dev.omedia.service;

import dev.omedia.domain.Car;
import dev.omedia.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
@ActiveProfiles("test")
class CarServiceTest {
    @SpyBean
    private CarService service;
    @Autowired
    private CarRepository repository;


    @BeforeEach
    public void setUp(){
        repository.deleteAll();
        repository.resetId();
    }

    @Test
    void createCar() {
        //Given
        Car car = new Car("1", "BMW", 2000);
        //When
        service.createCar(car);
        //Then
        //TODO: Check if event was sent
        //TODO: Check event validity
        Optional<Car> carById = repository.findById(1);
        Assertions.assertTrue(carById.isPresent());
        Assertions.assertEquals(car, carById.get());
    }

    @Test
    void getCar() {
        //Given
        Car car = new Car("1", "BMW", 2000);
        repository.save(car);
        //When
        Car actualCar = service.getCar(car.getUuid());
        //Then
        Assertions.assertEquals(car,actualCar);
    }

    @Test
    void getCarThrowException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->service.getCar("2"));
    }

    @Test
    void getAllCars() {
        //Given
        Car mock1 = new Car("1", "ragac", 2000);
        Car mock2 = new Car("2", "ragac1", 2000);
        List<Car> mockList = List.of(mock1, mock2);
        repository.saveAll(mockList);
        //When
        Iterable<Car> allCars = service.getAllCars();
        List<Car> result = StreamSupport.stream(allCars.spliterator(), false)
                        .collect(Collectors.toList());
        //Then
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(mockList, result);
    }

    @Test
    void update() {
        //Given
        Car mock = new Car("1", "ragac", 2000);
//        Mockito.when(service.getCar(Mockito.anyInt())).thenReturn(mock);
        Mockito.doReturn(mock).when(service).getCar(Mockito.anyString());
        //When
        Car updatedMock = new Car("1", "ragac1", 2000);
        Car updated = service.update(updatedMock.getUuid(), updatedMock);
        //Then
        Assertions.assertEquals(updatedMock, updated);
    }

    @Test
    void updateThrowsException(){
        //Given
        Mockito.doThrow(IllegalArgumentException.class).when(service).getCar(Mockito.anyString());
        //
        Car updatedMock = new Car("1", "ragac1", 2000);
        Assertions.assertThrows(IllegalArgumentException.class, ()->service.update(updatedMock.getUuid(), updatedMock));
    }
}