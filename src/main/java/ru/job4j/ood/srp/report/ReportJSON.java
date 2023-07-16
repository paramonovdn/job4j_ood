package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Gson gson;

    public ReportJSON(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        JsonArray jsonArray = new JsonArray();
        for (Employee e : employees) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", e.getName());
            jsonObject.addProperty("hired", dateTimeParser.parse(e.getHired()));
            jsonObject.addProperty("fired", dateTimeParser.parse(e.getFired()));
            jsonObject.addProperty("salary", e.getSalary());
            jsonArray.add(jsonObject);
        }
        return gson.toJson(jsonArray);
    }
}
