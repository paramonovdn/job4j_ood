package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    private StringBuilder result = new StringBuilder();
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> result.append(delimiter(i.getNumber().length()) + i.getName() + " " + i.getNumber() + "\n"));
        System.out.println(result);
    }
    public String delimiter(int lenght) {
        StringBuilder delimiter = new StringBuilder();
        if (lenght > 2) {
            for (int i = 0; i < lenght; i++) {
                delimiter.append("-");
            }
        }
        return delimiter.toString();
    }

    public StringBuilder getResult() {
        return result;
    }

    public void setResult(StringBuilder result) {
        this.result = result;
    }

}
