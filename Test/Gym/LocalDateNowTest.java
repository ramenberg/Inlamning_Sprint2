package Gym;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public Date class LocalDateNowTest {

    LocalDateNow ld = new LocalDateNow();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LocalDate now = LocalDate.now();
    sdf.format(now);
    return now;
}
