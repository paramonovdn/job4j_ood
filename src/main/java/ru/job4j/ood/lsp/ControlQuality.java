package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class ControlQuality {
    Warehous warehouse;
    Shop shop;
    Trash trash;

    public ControlQuality(Warehous warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void control(Food food) {
        LocalDateTime createTime = food.createDate;
        LocalDateTime exTime = food.expiryDate;
        LocalDateTime now = LocalDateTime.now();
        float fullTime = MINUTES.between(createTime, exTime);
        float tailTime = MINUTES.between(now, exTime);
        float percent = 100 - tailTime * 100 / fullTime;
        if (percent < 25) {
            warehouse.put(food);
        } else if (percent >= 25 && percent <= 75) {
            shop.put(food);
        } else if (percent > 75 && percent < 100) {
            food.price -= food.discount;
            shop.put(food);
        } else {
            trash.put(food);
        }
    }
}
