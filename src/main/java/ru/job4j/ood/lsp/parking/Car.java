package ru.job4j.ood.lsp.parking;

public class Car {

    String name;
    private int size;

    public Car(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
