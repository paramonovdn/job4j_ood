package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {
    ControlQuality controlQuality;
    Warehous warehous;
    Shop shop;
    Trash trash;

    List<Food> foodList;

    public void init() {
        List<Store> stores = new ArrayList<>();
        foodList = new ArrayList<>();
        controlQuality = new ControlQuality(stores);
        warehous = new Warehous(controlQuality);
        shop = new Shop(controlQuality);
        trash = new Trash(controlQuality);
        stores.add(warehous);
        stores.add(shop);
        stores.add(trash);
        Food apple = new Fruit("apple", LocalDateTime.of(2023, 11, 20, 10, 0, 0),
                LocalDateTime.of(2023, 7, 19, 10, 0, 0), 100.00f, 20.00f);
        Food lemon = new Fruit("lemon", LocalDateTime.of(2023, 7, 21, 10, 0, 0),
                LocalDateTime.of(2023, 6, 18, 10, 0, 0), 100.00f,  20.00f);
        Food orange = new Fruit("orange", LocalDateTime.of(2023, 7, 18, 10, 0, 0),
                LocalDateTime.of(2023, 5, 19, 10, 0, 0), 100.00f, 20.00f);
        foodList.add(apple);
        foodList.add(lemon);
        foodList.add(orange);
    }

    @Test
    public void generalTest() {
        init();
        LocalDateTime distributionDate = LocalDateTime.of(2023, 7, 20, 10, 0, 0);
        controlQuality.control(foodList, distributionDate);

        String warehousResult = warehous.findAll().toString();
        String shopResult = shop.findAll().toString();
        String trashResult = trash.findAll().toString();

        String warehousExpected = "[Food{name='apple', expiryDate=2023-11-20T10:00, createDate=2023-07-19T10:00, price=100.0, discount=20.0}]";
        String shopExpected = "[Food{name='lemon', expiryDate=2023-07-21T10:00, createDate=2023-06-18T10:00, price=80.0, discount=20.0}]";
        String trashExpected = "[Food{name='orange', expiryDate=2023-07-18T10:00, createDate=2023-05-19T10:00, price=100.0, discount=20.0}]";

        assertThat(warehousResult).isEqualTo(warehousExpected);
        assertThat(shopResult).isEqualTo(shopExpected);
        assertThat(trashResult).isEqualTo(trashExpected);
    }

    @Test
    public void resortTest() {
        init();
        LocalDateTime distributionDate = LocalDateTime.of(2023, 7, 20, 10, 0, 0);
        LocalDateTime resortDate = LocalDateTime.of(2023, 11, 22, 10, 0, 0);

        controlQuality.control(foodList, distributionDate);
        controlQuality.resort(resortDate);

        String resortWarehousResult = warehous.findAll().toString();
        String resortShopResult = shop.findAll().toString();
        String resortTrashResult = trash.findAll().toString();

        String resortWarehousExpected = "[]";
        String resortShopExpected = "[]";
        String resortTrashExpected = "[Food{name='apple', expiryDate=2023-11-20T10:00, createDate=2023-07-19T10:00, price=100.0, discount=20.0}, Food{name='lemon', expiryDate=2023-07-21T10:00, createDate=2023-06-18T10:00, price=80.0, discount=20.0}]";

        assertThat(resortWarehousResult).isEqualTo(resortWarehousExpected);
        assertThat(resortShopResult).isEqualTo(resortShopExpected);
        assertThat(resortTrashResult).isEqualTo(resortTrashExpected);
    }
}
