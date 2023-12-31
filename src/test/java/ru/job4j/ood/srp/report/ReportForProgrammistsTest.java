package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.assertThat;

public class ReportForProgrammistsTest {

    @Test
    public void whenSalaryInDescendingOrder() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Igor", now, now, 90);
        Employee worker3 = new Employee("Oleg", now, now, 120);
        Employee worker4 = new Employee("John", now, now, 95);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);
        Report engine = new ReportForProgrammists(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("Name,Hired,Fired,Salary")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(",")
                .append(parser.parse(worker1.getHired())).append(",")
                .append(parser.parse(worker1.getFired())).append(",")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(",")
                .append(parser.parse(worker2.getHired())).append(",")
                .append(parser.parse(worker2.getFired())).append(",")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(",")
                .append(parser.parse(worker3.getHired())).append(",")
                .append(parser.parse(worker3.getFired())).append(",")
                .append(worker3.getSalary())
                .append(System.lineSeparator())
                .append(worker4.getName()).append(",")
                .append(parser.parse(worker4.getHired())).append(",")
                .append(parser.parse(worker4.getFired())).append(",")
                .append(worker4.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
