package ru.job4j.ood.lsp;

public class Trash extends AbstractStore {

    public Trash(ControlQuality controlQuality) {
        super(controlQuality);
    }

    public void put(Food food) {
        if (controlQuality.getPercent() >= 100) {
            super.put(food);
        }
    }
}
