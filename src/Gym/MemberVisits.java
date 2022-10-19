package Gym;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberVisits extends MemberList {

    public List<Member> getListOfMembersFromVisitsFile() {
        return listOfMembersFromVisitsFile;
    }
    protected List<Member> listOfMembersFromVisitsFile = new ArrayList<>();
    protected List<Member> addMemberVisit(Member member) {
        LocalDate date = Date.getCurrentDate();
        try (BufferedWriter buf = Files.newBufferedWriter(FilePath.visitsFilePath, StandardOpenOption.APPEND)) {
            member.setLastVisitDate(date);
            buf.append(member.toStringVisits()).append("\n");
            Member m = new Member(member.getName(), member.getPersonalIdNumber(), date);
            listOfMembersFromVisitsFile.add(m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return listOfMembersFromVisitsFile;
    }
}
