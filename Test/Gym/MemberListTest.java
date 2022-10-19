package Gym;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberListTest {

    final Path filePath = FilePath.filePath;

    List<Member> testList = new ArrayList<>();
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
}
