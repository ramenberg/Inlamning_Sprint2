package Gym;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
    Date dt = new Date();

    LocalDate todayTest = LocalDate.now();
    @Test
    public void DateTest() {
        LocalDate date = Date.getCurrentDate();
        LocalDate testdate2 = LocalDate.parse("2021-10-16");
        LocalDate testdate3 = LocalDate.parse("2022-01-01");

        assertEquals(date, todayTest);
        assertNotEquals(date, testdate2);
        assertNotEquals(date, testdate3);
    }
}
