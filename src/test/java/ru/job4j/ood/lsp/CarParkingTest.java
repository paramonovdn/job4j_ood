package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled
public class CarParkingTest {

    @Test
    public void whenThereArePlacesTest() {
        int parkingSpaceSize = 3;
        CarParking carParking = new GeneralCarParking(parkingSpaceSize);
        List<Car> carList = new ArrayList<>();
        Car passangerCar = new Car("Opel Astra", 1);
        Car cargoCar = new Car("Kamaz", 2);
        carList.add(passangerCar);
        carList.add(cargoCar);
        ControlParking controlParking = new ControlParking(carParking);
        controlParking.control(carList);

        String result = carParking.howMuchCarPlacesBusy().toString();
        String expected = "[Car{name='Opel Astra', size=1}, Car{name='Kamaz', size=2}, Car{name='Kamaz', size=2}]";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenThereAreNoPlacesTest() {
        int parkingSpaceSize = 4;
        CarParking carParking = new GeneralCarParking(parkingSpaceSize);
        List<Car> carList = new ArrayList<>();
        Car passangerCar = new Car("Opel Astra", 1);
        Car cargoCar = new Car("Kamaz", 2);
        carList.add(passangerCar);
        carList.add(cargoCar);
        carList.add(cargoCar);
        ControlParking controlParking = new ControlParking(carParking);

        assertThatThrownBy(() -> controlParking.control(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Парковочных мест для данного типа автомобиля нет!");
    }
}
