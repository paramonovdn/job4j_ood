package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface CarParking {

    public void put(Car car);

    public List<Car> howMuchCarPlacesBusy();

}
