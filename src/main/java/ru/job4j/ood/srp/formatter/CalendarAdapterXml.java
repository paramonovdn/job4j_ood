package ru.job4j.ood.srp.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapterXml extends XmlAdapter<String, Calendar> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String d) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DATE_FORMAT.parse(d));
        return cal;
    }

    @Override
    public String marshal(Calendar d) {
        return DATE_FORMAT.format(d.getTime());
    }
}
