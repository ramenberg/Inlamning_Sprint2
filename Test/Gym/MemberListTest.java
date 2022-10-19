package Gym;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberListTest {

    final Path filePath = FilePath.filePath;

    // Local date variables
    static LocalDate currentDate = LocalDate.now();
    static LocalDate currentDateMinus13Months = currentDate.minusMonths(13); // for false membership
    static LocalDate currentDateMinus6Months = currentDate.minusMonths(6); // for valid date
    LocalDate testdate1 = currentDateMinus6Months; // active
    LocalDate testdate2 = currentDateMinus13Months; // inactive

    MemberList ml = new MemberList();
    @Test
    public void createMemberListTest() {

        List<Member> testlist = ml.createMemberListReadFromFile();
        //assert
        assertEquals(testlist.size(), 14);
        Member p1 = testlist.get(0);
        Member p2 = testlist.get(1);
        assertEquals(p1.getName(), "Alhambra Aromes");
        assertEquals(p1.getPersonalIdNumber(), "7703021234");
        assertEquals(p2.getName(), "Bear Belle");
        assertEquals(p2.getPersonalIdNumber(), "8204021234");
    }

    @Test
    public void validateMembershipStatus() {
        assertTrue(ml.validateMembership(testdate1));
        assertFalse(ml.validateMembership(testdate2));
    }
    @Test
    public void testforSearchMemberMethod() {

        List<Member> testlist = ml.createMemberListReadFromFile();

        String testName1 = "Nahema Ninsson"; // true
        String testName2 = "Pelle Karlsson";
        String testPersonalId1 = "8204021234"; // true
        String testPersonalId2 = "8706351234";


        assertTrue(ml.searchMemberByNameOrPersonalIdNumber(testName1));
        assertTrue(ml.searchMemberByNameOrPersonalIdNumber(testPersonalId1));

        assertFalse(ml.searchMemberByNameOrPersonalIdNumber(testName2));
        assertFalse(ml.searchMemberByNameOrPersonalIdNumber(testPersonalId2));
    }

}
