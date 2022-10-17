package Gym;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberListTest {

    final Path filePath = Paths.get("src/Gym/customers.txt");
    final Path visitsFilePath = Paths.get("src/Gym/memberVisitDates.txt");


    List<Member> testList = new ArrayList<>();
    MemberList ml = new MemberList();

//    ml.createMemberList();
    @Test
    public void createMemberListTest() {
        //assert
        assertEquals(testList.size(), 14);
        Member p1 = testList.get(0);
        Member p2 = testList.get(1);
        assertEquals(p1.getName(), "Alhambra Aromes");
        assertEquals(p1.getPersonalIdNumber(), "7703021234");
        assertEquals(p1.getLastPaymentDate(), "2022-07-01");
        assertEquals(p2.getName(), "Bear Belle");
        assertEquals(p2.getPersonalIdNumber(), "8204021234");
        assertEquals(p2.getLastPaymentDate(), "2019-12-02");
    }
}
