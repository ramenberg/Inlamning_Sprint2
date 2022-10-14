package Gym;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ReadDateTest {

    ReadDate rd = new ReadDate();


    Date d1 = sdf.parse("2022-10-14");
    Date d2 = sdf.parse("2021-10-15");
    Date d3 = sdf.parse("2021-10-14");
    Date d4 = sdf.parse("2021-10-13");

    assertTrue(rd.dateReader(d1, d2))
}
