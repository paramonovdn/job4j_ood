package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportForHr implements Report {
    private final Store store;
    public ReportForHr(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        Map<Employee, Double> employeeMap = new HashMap<>();
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            employeeMap.put(employee, employee.getSalary());
        }

        Map<Employee, Double> sortedMap =
                employeeMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedMap.forEach((key, value) -> text.append(key.getName() + " " + value + System.lineSeparator()));

        return text.toString();


    }
}
