package ru.job4j.ood.tdd;

import java.util.Objects;

public class Ticket3D implements Ticket {

    int row;
    int column;

    public Ticket3D() {
        this.row = 1;
        this.column = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket3D ticket3D = (Ticket3D) o;
        return row == ticket3D.row && column == ticket3D.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
