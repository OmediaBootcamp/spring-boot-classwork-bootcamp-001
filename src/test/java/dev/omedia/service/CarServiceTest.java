package dev.omedia.service;

import dev.omedia.models.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class CarServiceTest {

    @SpyBean
    private CarService carService;

    @Test
    void createCar() {
    }

    @Test
    void getCar() {
    }

    @Test
    void updateCar() {

        // given
//        Mockito.when(carService.getCar(Mockito.anyInt())).thenReturn(new Car(15, "Giorgi"));
        Mockito.doReturn(new Car(15, "Giorgi")).when(carService).getCar(Mockito.anyInt());

        // when
        carService.updateCar(15, "Lasha");

        // then
        Assertions.assertEquals(new Car(15, "Lasha"), carService.getCar(15));
        org.assertj.core.api.Assertions.assertThat(carService.getCar(15)).isEqualTo(new Car(15, "Lasha"));
    }

    @Test
    void notUpdateCar() {
        // given
        Mockito.doThrow(new IllegalArgumentException()).when(carService).getCar(Mockito.anyInt());
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> carService.updateCar(15, "Lasha"));
    }
}