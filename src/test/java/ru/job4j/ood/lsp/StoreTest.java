package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {

    @Test
    public void warehousTest() {
        Food apple = new Fruit("Golden apple", LocalDateTime.of(2023, 11, 20, 10, 0, 0), LocalDateTime.of(2023, 7, 19, 10, 0, 0), 100.00f, 20.00f);

        Warehous warehous = new Warehous();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(warehous, shop, trash);
        controlQuality.control(apple);

        String warehousResult = warehous.findAll().toString();
        String shopResult = shop.findAll().toString();
        String trashResult = trash.findAll().toString();

        String warehousExpected = "[Food{name='Golden apple', expiryDate=2023-11-20T10:00, createDate=2023-07-19T10:00, price=100.0, discount=20.0}]";
        String shopExpected = "[]";
        String trashExpected = "[]";
        assertThat(warehousResult).isEqualTo(warehousExpected);
        assertThat(shopResult).isEqualTo(shopExpected);
        assertThat(trashResult).isEqualTo(trashExpected);
    }

    @Test
    public void shopTest() {
        Food apple = new Fruit("Golden apple", LocalDateTime.of( 2023, 7, 20, 10, 0, 0), LocalDateTime.of( 2023, 6, 18, 10, 0, 0), 100.00f,  20.00f);

        Warehous warehous = new Warehous();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(warehous, shop, trash);
        controlQuality.control(apple);

        String warehousResult = warehous.findAll().toString();
        String shopResult = shop.findAll().toString();
        String trashResult = trash.findAll().toString();

        String warehousExpected = "[]";
        String shopExpected = "[Food{name='Golden apple', expiryDate=2023-07-20T10:00, createDate=2023-06-18T10:00, price=80.0, discount=20.0}]";
        String trashExpected = "[]";
        assertThat(warehousResult).isEqualTo(warehousExpected);
        assertThat(shopResult).isEqualTo(shopExpected);
        assertThat(trashResult).isEqualTo(trashExpected);
    }

    @Test
    public void trashTest() {
        Food apple = new Fruit("Golden apple", LocalDateTime.of( 2023, 7, 18, 10, 0, 0), LocalDateTime.of( 2023, 5, 19, 10, 0, 0), 100.00f, 20.00f);

        Warehous warehous = new Warehous();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(warehous, shop, trash);
        controlQuality.control(apple);

        String warehousResult = warehous.findAll().toString();
        String shopResult = shop.findAll().toString();
        String trashResult = trash.findAll().toString();

        String warehousExpected = "[]";
        String shopExpected = "[]";
        String trashExpected = "[Food{name='Golden apple', expiryDate=2023-07-18T10:00, createDate=2023-05-19T10:00, price=100.0, discount=20.0}]";
        assertThat(warehousResult).isEqualTo(warehousExpected);
        assertThat(shopResult).isEqualTo(shopExpected);
        assertThat(trashResult).isEqualTo(trashExpected);
    }
}
