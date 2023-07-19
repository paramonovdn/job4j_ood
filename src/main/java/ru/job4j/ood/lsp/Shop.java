package ru.job4j.ood.lsp;

import java.util.List;

public class Shop extends AbstractStore {

    public Shop(ControlQuality controlQuality) {
        super(controlQuality);
    }

    @Override
    public void put(Food food) {
        if (controlQuality.getPercent() >= 25 && controlQuality.getPercent() <= 75) {
            super.put(food);
        } else if (controlQuality.getPercent() > 75 && controlQuality.getPercent() < 100) {
            food.setPrice(food.getPrice() - food.getDiscount());
            super.put(food);
        }
    }
}
