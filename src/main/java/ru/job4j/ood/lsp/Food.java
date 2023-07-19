package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public abstract class Food {
    private String name;
    private LocalDateTime expiryDate;
    private LocalDateTime  createDate;
    private float price;
    private float discount;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
