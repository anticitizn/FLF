package Person;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {
    public static Calendar convertStringToCalendarDate(String string) {
        Calendar calendar = null;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = simpleDateFormat.parse(string);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return calendar;
    }
}