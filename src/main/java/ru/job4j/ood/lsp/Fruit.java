package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public class Fruit extends Food {

    public Fruit(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
