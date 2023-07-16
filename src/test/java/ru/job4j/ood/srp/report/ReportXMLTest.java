package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportXMLTest {
    @Test
    public void whenParseEmployeeToXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("John", now, now, 90);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append("\n")
                .append("<employees>").append("\n").append("    <employee>").append("\n")
                .append("        <name>Ivan</name>").append("\n")
                .append("        <hired>").append(parser.parse(worker1.getHired())).append("</hired>").append("\n")
                .append("        <fired>").append(parser.parse(worker1.getHired())).append("</fired>").append("\n")
                .append("        <salary>100.0</salary>").append("\n")
                .append("    </employee>").append("\n").append("    <employee>").append("\n")
                .append("        <name>John</name>").append("\n")
                .append("        <hired>").append(parser.parse(worker2.getHired())).append("</hired>").append("\n")
                .append("        <fired>").append(parser.parse(worker2.getHired())).append("</fired>").append("\n")
                .append("        <salary>90.0</salary>").append("\n").append("    </employee>")
                .append("\n").append("</employees>").append("\n");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
