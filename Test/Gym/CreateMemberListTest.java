package Gym;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMemberListTest {

    @Test
    public void getAllMembers_whenMembersFileFound_shouldReturnListOfAllMembers() {
        //arrange
        var CreateMemberList = new CreateMemberList();

        //act
        List<Person> testList = CreateMemberList.getAllMembers();

        //assert
        assertEquals(testList.size(), 14);
        Person p1 = testList.get(0);
        Person p2 = testList.get(1);
        assertEquals(p1.getName(), "Alhambra Aromes");
        assertEquals(p1.getPersonalIdNumber(), "7703021234");
        assertEquals(p1.getLastPaymentDate(), "2022-07-01");
        assertEquals(p2.getName(), "Bear Belle");
        assertEquals(p2.getPersonalIdNumber(), "8204021234");
        assertEquals(p2.getLastPaymentDate(), "2019-12-02");
    }
}
