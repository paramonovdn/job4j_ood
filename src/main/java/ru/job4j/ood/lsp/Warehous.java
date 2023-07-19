package ru.job4j.ood.lsp;

public class Warehous extends AbstractStore {


    public Warehous(ControlQuality controlQuality) {
        super(controlQuality);
    }

    @Override
    public void put(Food food) {
        if (controlQuality.getPercent() < 25) {
            super.put(food);
        }
    }
}
