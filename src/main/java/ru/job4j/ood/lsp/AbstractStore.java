package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    List<Food> foodList = new ArrayList<>();

    @Override
    public void put(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> findAll() {
        return foodList;
    }
}
