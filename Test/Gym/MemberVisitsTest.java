package Gym;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberVisitsTest extends MemberList {
    MemberList ml = new MemberList();
    MemberVisits mv = new MemberVisits();
    @Test
    void addMemberVisitsTest() {

        List<Member> testList = ml.createMemberListReadFromFile();
        Member testMember1 = testList.get(0); // Alhambra Aromes
        Member testMember2 = testList.get(1); // Bear Belle

        mv.addMemberVisit(testMember1);
        mv.addMemberVisit(testMember2);

        assertEquals(testList.get(0).getName(), "Alhambra Aromes");
        assertEquals(testList.get(1), testMember2);
        assertNotEquals(testList.get(0), testMember2);
    }
}