package Gym;

import java.time.LocalDate;

public class Date {
    static LocalDate currentDate = LocalDate.now();
    LocalDate currentDateMinus12Months = currentDate.minusMonths(12);
    public static LocalDate getCurrentDate() {
        return currentDate;
    }
    public LocalDate getCurrentDateMinus12Months() {
        return currentDateMinus12Months;
    }
}
