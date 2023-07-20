package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class AbstractCarParking implements CarParking {

    protected int parkingSpacesSize;
    protected List<Car> parkingSpaces = new ArrayList<>(parkingSpacesSize);
    public void put(Car car) {
        parkingSpaces.add(car);
    }

    public List<Car> howMuchCarPlacesBusy() {
        return parkingSpaces;
    }
}
