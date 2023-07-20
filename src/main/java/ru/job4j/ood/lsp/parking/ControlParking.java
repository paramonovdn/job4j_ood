package ru.job4j.ood.lsp.parking;

import java.util.List;

public class ControlParking {

    CarParking carParking;

    public ControlParking(CarParking carParking) {
        this.carParking = carParking;
    }

    public void control(List<Car> cars) {
        for (Car car : cars) {
            carParking.put(car);
        }
    }
}
