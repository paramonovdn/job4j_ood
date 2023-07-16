package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.sound.midi.Soundbank;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportJSONTest {

    @Test
    public void whenParseEmployeeToJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("John", now, now, 90);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportJSON(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("[").append("\n").append("  {").append("\n")
                .append("    \"name\": \"Ivan\",").append("\n")
                .append("    \"hired\": \"").append(parser.parse(worker1.getHired()))
                .append("\",").append("\n")
                .append("    \"fired\": \"").append(parser.parse(worker1.getFired()))
                .append("\",").append("\n")
                .append("    \"salary\": ").append(worker1.getSalary()).append("\n")
                .append("  },").append("\n")
                .append("  {").append("\n")
                .append("    \"name\": \"John\",").append("\n")
                .append("    \"hired\": \"").append(parser.parse(worker2.getHired()))
                .append("\",").append("\n")
                .append("    \"fired\": \"").append(parser.parse(worker2.getFired()))
                .append("\",").append("\n")
                .append("    \"salary\": ").append(worker2.getSalary()).append("\n")
                .append("  }").append("\n").append("]");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
