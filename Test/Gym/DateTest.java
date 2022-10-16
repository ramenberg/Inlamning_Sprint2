package Gym;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

//    dateCompare dc = new dateCompare();
    Date dt = new Date();


    @Test
    public void DateTest() {
        String date = dt.getCurrentDate().toString();
        String testdate1 = "2022-10-16";
        String testdate2 = "2021-10-16";
        String testdate3 = "2022-01-01";

        assertEquals(date, testdate1);
        assertNotEquals(date, testdate2);
        assertNotEquals(date, testdate3);
    }
//    @Test
//    public void DateCompareTest() {
//
//    String todayDate = "2022-10-16";
//    String testDate1 = "2022-10-16";
//    String testDate2 = "2022-10-15";
//    String testDate3 = "2021-10-16";
//        assert(dt.todayDate > date1);
//        assert(dt.today != date 2)
//
//        //Today
//        System.out.println("Idag: " + currentDate);
//
//        // A year ago today
//        System.out.println("Idag minus 12 månader: " + currentDateMinus12Months);
//    }


}
