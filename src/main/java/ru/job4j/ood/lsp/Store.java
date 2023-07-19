package ru.job4j.ood.lsp;

import java.util.List;

public interface Store {

    public void put(Food food);

    public List<Food> findAll();
}
