package Gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CreateMemberList extends Person {

    public List<Person> getAllMembers() {
        return new ArrayList<>(makeMemberList());
    }

    public List<Person> makeMemberList() {
        final Path filePath = Paths.get("src/Gym/customers.txt");
        String firstRow;
        String[] splitter;
        List<Person> memberList = new ArrayList<>();

        try(BufferedReader buf = Files.newBufferedReader(filePath)) {
            while((firstRow = buf.readLine()) != null) {
                Person person = new Person();
                memberList.add(person);
                splitter = firstRow.split(",");
                person.setPersonalIdNumber(splitter[0].trim());
                person.setName(splitter[1].trim());
                person.setLastPaymentDate(buf.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return memberList;
    }
}
