package Gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {

    // List<Member>
    protected List<Member> listOfMembersFromFile = new ArrayList<>();

    public List<Member> getCreatedMemberList() {
        return listOfMembersFromFile;
    }

    protected List<Member> createMemberListReadFromFile() {
        String firstRowInFile;
        String[] firstRowInFileSplitter;
        String name, personalIdNumber;
        LocalDate paymentDate;
        boolean membershipValidation;

        try (BufferedReader buf = Files.newBufferedReader(FilePath.filePath)) {
            while ((firstRowInFile = buf.readLine()) != null) {
                firstRowInFileSplitter = firstRowInFile.split(",");
                personalIdNumber = (firstRowInFileSplitter[0].trim());
                name = (firstRowInFileSplitter[1].trim());
                paymentDate = LocalDate.parse(buf.readLine().trim(), Date.formatter);
                membershipValidation = validateMembership(paymentDate);
                Member mem = new Member(personalIdNumber, name, paymentDate, membershipValidation);
                addMember(mem);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfMembersFromFile;
    }

    // Getters & Setters

    // Methods
    protected void addMember(Member member) {
        listOfMembersFromFile.add(member);
    }

    public boolean validateMembership(LocalDate paymentDate) {
        boolean membershipValid;
        membershipValid = paymentDate.isAfter(Date.getCurrentDateMinusOneYear());
        return membershipValid;
    }

    // Member & Search member
    protected Member foundMemberInSearch;
    public Member getFoundMemberInSearch() {
        return foundMemberInSearch;
    }
    public void setFoundMemberInSearch(Member foundMemberInSearch) {
        this.foundMemberInSearch = foundMemberInSearch;
    }

    public boolean searchMemberByNameOrPersonalIdNumber(String input) {
        List<Member> list = getCreatedMemberList();
        for (Member member : list)
            if (member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().equals(input))) {
                System.out.println("\nInformation om \"" + input + "\":");
                setFoundMemberInSearch(member);
                System.out.println(member);
                return true;
            } return false;
    }
}

