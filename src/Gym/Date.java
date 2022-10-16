package Gym;

import java.time.LocalDate;

public class Date {
    LocalDate currentDate = LocalDate.now();
    LocalDate currentDateMinus12Months = currentDate.minusMonths(12);
    public LocalDate getCurrentDate() {
        return currentDate;
    }
    public LocalDate getCurrentDateMinus12Months() {
        return currentDateMinus12Months;
    }
}
