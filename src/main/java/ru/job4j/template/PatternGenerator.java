package ru.job4j.template;

import java.util.Map;

public class PatternGenerator implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        String result = "";
        if (args.containsKey("name") && args.containsKey("subject") && args.size() == 2) {
            result = "I am a " + args.get("name") + ", Who are " + args.get("subject") + "? ";
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
