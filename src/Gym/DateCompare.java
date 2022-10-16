package Gym;

import java.time.LocalDate;

public class DateCompare {

    public void DateCompare() { // true = betalt mindre än 12 månader sedan
//        LocalDate now = getCurrentDate();
//        LocalDate currentDateMinus12Months = now.minusMonths(12);
//        System.out.println(currentDateMinus12Months);

        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus12Months = currentDate.minusMonths(12);

        //Today 2022-10-16
        System.out.println("Idag: " + currentDate);

        // 2021-10-16
        System.out.println("Idag minus 12 månader: " + currentDateMinus12Months);

        LocalDate date1 = LocalDate.of(2021, 04, 10);
        System.out.println("\ndate1: " + date1);
        if (date1.isBefore(currentDateMinus12Months)) {
            System.out.println("Medlemskapet är inte längre aktivt.");
        }
        else
            System.out.println("Medlemskapet är aktivt.");
    }
}
