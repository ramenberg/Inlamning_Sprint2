package Gym;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    static LocalDate currentDate = LocalDate.now();
    static LocalDate currentDateMinusOneYear = currentDate.minusYears(1);

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate getCurrentDate() {
        return currentDate;
    }
    public static LocalDate getCurrentDateMinusOneYear() {
        return currentDateMinusOneYear;
    }
}
