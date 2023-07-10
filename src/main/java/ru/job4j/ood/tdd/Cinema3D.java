package ru.job4j.ood.tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {

    List<Session> sessionList = new ArrayList<>();
    @Override
    public List<Session> find(Predicate<Session> filter) {
        List<Session> result = new ArrayList<>();
        for (Session session: sessionList) {
            if (filter.test(session)) {
                result.add(session);
            }
        }
        return result;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        if (row > 0 && column > 0 && date.after(Calendar.getInstance())) {
            return  new Ticket3D();
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void add(Session session) {
        sessionList.add(session);
    }
}
