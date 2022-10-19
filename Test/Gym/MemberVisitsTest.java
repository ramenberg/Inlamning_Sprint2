package Gym;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberVisitsTest extends MemberList {

    static final Path visitsFilePath = Paths.get("Test/Gym/memberVisitsTest.txt");

    final Path filePath = Paths.get("Test/Gym/customersTest.txt");
    MemberList ml = new MemberList();
    MemberVisits mv = new MemberVisits();
    @Test
    void addMemberVisitsTest(@TempDir Path tempDir) {
        Path visits = tempDir.resolve(visitsFilePath);

        List<Member> testlist = ml.createMemberListReadFromFile();
        Member testMember1 = testlist.get(0); // Alhambra Aromes
        Member testMember2 = testlist.get(1); // Bear Belle

        mv.addMemberVisit(testMember1);
        mv.addMemberVisit(testMember2);
        List <Member> visitslist = mv.getListOfMembersFromVisitsFile();
        visitslist.add(testMember1);
        visitslist.add(testMember2);

        assertEquals(testlist.get(0).getName(), "Alhambra Aromes");
        assertEquals(testlist.get(1), testMember2);
        assertNotEquals(testlist.get(0), testMember2);
        assertEquals(visitslist.size(), 4); // 2 members * 2 rader
    }
}