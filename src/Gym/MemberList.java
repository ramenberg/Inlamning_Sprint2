package Gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {

    // List<Member>
    protected List<Member> memberList = new ArrayList<>();

    public List<Member> getMemberList() {
        return memberList;
    }

    protected List<Member> createMemberList() {
        String firstRow;
        String[] splitter;
        String name, pNr;
        LocalDate paymentDate;
        boolean membershipValidation;

        try (BufferedReader buf = Files.newBufferedReader(FilePath.filePath)) {
            while ((firstRow = buf.readLine()) != null) {
                splitter = firstRow.split(",");
                pNr = (splitter[0].trim());
                name = (splitter[1].trim());
                paymentDate = LocalDate.parse(buf.readLine().trim(), Date.formatter);
                membershipValidation = validateMembership(paymentDate);
                Member mem = new Member(pNr, name, paymentDate, membershipValidation);
                addMember(mem);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return memberList;
    }

    // Getters & Setters

    // Methods
    protected void addMember(Member member) {
        memberList.add(member);
    }

    public boolean validateMembership(LocalDate paymentDate) {
        boolean membershipValid;
        membershipValid = paymentDate.isAfter(Date.getCurrentDateMinusOneYear());
        return membershipValid;
    }

    // Member & Search member
    protected Member foundMember;
    public Member getFoundMember() {
        return foundMember;
    }
    public void setFoundMember(Member foundMember) {
        this.foundMember = foundMember;
    }

    public boolean searchMemberbyNameOrPersonalIdNumber(String input) {
        List<Member> list = memberList;
        for (Member member : list)
            if (member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().equals(input))) {
                System.out.println("Information om \"" + input + "\":");
                setFoundMember(member);
                System.out.println(member);
                return true;
            } return false;
    }
}

