package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected ControlQuality controlQuality;
    private List<Food> foodList = new ArrayList<>();

    public AbstractStore(ControlQuality controlQuality) {
        this.controlQuality = controlQuality;
    }

    @Override
    public void put(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> findAll() {
        return foodList;
    }

    @Override
    public void removeAll() {
        foodList.clear();
    }


}
