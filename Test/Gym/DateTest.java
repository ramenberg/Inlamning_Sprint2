package Gym;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
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
}
