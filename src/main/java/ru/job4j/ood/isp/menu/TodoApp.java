package ru.job4j.ood.isp.menu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TodoApp {

    private final ActionDelegate stabAction = System.out::println;

    private final ActionDelegate defaultAction = () -> System.out.println("Some action");

    private void showMenu() {
        System.out.println("\nВыберите пункт меню:");
        System.out.println("1.Добавить элемент в корень меню.");
        System.out.println("2.Добавить элемент в родительскому элементу.");
        System.out.println("3.Some action");
        System.out.println("4.Печать меню.");
        System.out.println("5.Выход.");
    }

    public static void main(String[] args) {
        TodoApp todoApp = new TodoApp();
        Menu menu = new SimpleMenu();

        boolean run = true;
        while (run) {
            Scanner in = new Scanner(System.in);
            todoApp.showMenu();
            String  num = in.nextLine();

            switch (num) {
                case "1":
                    System.out.println(num);
                    System.out.println("Введите наименование меню:");
                    String rootMenu = in.nextLine();
                    menu.add(Menu.ROOT, rootMenu, todoApp.stabAction);
                    System.out.println(rootMenu + " - добавлен в корень меню.");
                    break;
                case "2":
                    System.out.println(num);
                    System.out.println("Введите наименование родительского меню:");
                    String parentMenuItem = in.nextLine();
                    System.out.println(parentMenuItem);
                    System.out.println("Введите наименование меню:");
                    String childMenuItem = in.nextLine();
                    menu.add(parentMenuItem, childMenuItem, todoApp.stabAction);
                    System.out.println(childMenuItem + " добавлен к " + parentMenuItem);
                    break;
                case "3":
                    System.out.println(num);
                    System.out.println("Введите наименование меню:");
                    String menuItem = in.nextLine();
                    menu.add(Menu.ROOT, menuItem, todoApp.defaultAction);
                    System.out.println("Some action do");
                    break;
                case "4":
                    System.out.println(num);
                    SimpleMenuPrinter smp = new SimpleMenuPrinter();
                    smp.print(menu);
                    break;
                case "5":
                    System.out.println(num);
                    System.out.println("Выход.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введен неверный номер пункта.");
            }
        }
    }
}
