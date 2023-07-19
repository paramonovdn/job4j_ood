package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public abstract class Food {
    String name;
    LocalDateTime expiryDate;
    LocalDateTime  createDate;
    float price;
    float discount;

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, float discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "Food{"
               + "name='" + name + '\''
               +  ", expiryDate=" + expiryDate
               +  ", createDate=" + createDate
               + ", price=" + price
               + ", discount=" + discount
               +  '}';
    }


}
