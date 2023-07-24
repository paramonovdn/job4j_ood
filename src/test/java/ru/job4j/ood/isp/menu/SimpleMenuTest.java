package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Сходить в магазин",
                List.of("Купить продукты"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("Сходить в магазин").get());
        assertThat(new Menu.MenuItemInfo(
                "Купить продукты",
                List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."))
                .isEqualTo(menu.select("Купить продукты").get());
        assertThat(new Menu.MenuItemInfo(
                "Покормить собаку", List.of(), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Покормить собаку").get());
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenCheckPrint() {
        SimpleMenu menu = new SimpleMenu();
        SimpleMenuPrinter simpleMenuPrinter = new SimpleMenuPrinter();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);

        String expected = "Сходить в магазин 1." + "\n" + "----Купить продукты 1.1." + "\n" + "------Купить хлеб 1.1.1."
                            + "\n" + "------Купить молоко 1.1.2." + "\n" + "Покормить собаку 2."  + "\n";


        simpleMenuPrinter.print(menu);
        assertEquals(expected, simpleMenuPrinter.getResult().toString());
    }

    @Test
    public void whenCheckSelect() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);

        assertThat(new Menu.MenuItemInfo(
                "Купить хлеб", List.of(), STUB_ACTION, "1.1.1."))
                .isEqualTo(menu.select("Купить хлеб").get());

        assertThat(new Menu.MenuItemInfo(
                "Купить молоко", List.of(), STUB_ACTION, "1.1.2."))
                .isEqualTo(menu.select("Купить молоко").get());
    }

}
