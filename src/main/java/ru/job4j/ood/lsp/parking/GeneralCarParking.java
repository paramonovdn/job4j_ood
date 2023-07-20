package ru.job4j.ood.lsp.parking;

public class GeneralCarParking extends AbstractCarParking {
    public GeneralCarParking(int parkingSpacesSize) {
        super.parkingSpacesSize = parkingSpacesSize;
    }

    @Override
    public void put(Car car) {

        if (parkingSpaces.size() < parkingSpacesSize && parkingSpacesSize - parkingSpaces.size() >= car.getSize()) {
            if (car.getSize() > 1) {
                for (int i = 0; i < car.getSize(); i++) {
                    super.put(car);
                }
            } else {
                super.put(car);
            }
        } else {
            throw new IllegalArgumentException("Парковочных мест для данного типа автомобиля нет!");
        }
    }
}
