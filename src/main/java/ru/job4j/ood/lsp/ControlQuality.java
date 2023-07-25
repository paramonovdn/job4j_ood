package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ControlQuality {

    private float percent;
    private List<Store> stores;
    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void control(List<Food> foodList, LocalDateTime distributionDate) {
        for (Food food: foodList) {
            LocalDateTime createTime = food.getCreateDate();
            LocalDateTime exTime = food.getExpiryDate();
            float fullTime = MINUTES.between(createTime, exTime);
            float tailTime = MINUTES.between(distributionDate, exTime);
            percent = 100 - tailTime * 100 / fullTime;
            for (Store store: stores) {
                store.put(food);
                Shop shop = new Shop(new ControlQuality(stores));
            }
        }
    }

    public void resort(LocalDateTime resortDate) {
        List<Food> resortFoodList = new ArrayList<>();
        for (Store store: stores) {
            if (!(store instanceof Trash)) {
                resortFoodList.addAll(store.findAll());
            }
            store.removeAll();
        }
        control(resortFoodList, resortDate);
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
