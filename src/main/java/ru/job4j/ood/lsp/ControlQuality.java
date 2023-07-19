package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ControlQuality {

    private float percent;
    private List<Store> stores;
    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void control(Food food) {
        LocalDateTime createTime = food.getCreateDate();
        LocalDateTime exTime = food.getExpiryDate();
        LocalDateTime now = LocalDateTime.now();
        float fullTime = MINUTES.between(createTime, exTime);
        float tailTime = MINUTES.between(now, exTime);
        percent = 100 - tailTime * 100 / fullTime;
        for (Store store: stores) {
            store.put(food);
        }
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
