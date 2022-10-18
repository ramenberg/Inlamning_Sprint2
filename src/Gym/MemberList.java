package Gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    protected List<Member> memberList = new ArrayList<>();
    protected int memberFoundIndex = 0;

    public int getMemberFoundIndex() {
        return memberFoundIndex;
    }
    public void setMemberFoundIndex(int memberFoundIndex) {
        this.memberFoundIndex = memberFoundIndex;
    }

    protected void addMember(Member member) {
        memberList.add(member);
    }

    public List<Member> createMemberList() {
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

    public boolean validateMembership(LocalDate paymentDate) {
        boolean membershipValid;
        membershipValid = paymentDate.isAfter(Date.getCurrentDateMinusOneYear());
        return membershipValid;
    }

    public Member getMemberInList(int i) {
        return memberList.get(i);
    }

    public boolean searchMemberbyNameOrPersonalIdNumber(String input) {
        while (!memberList.isEmpty()) {
            for (Member member : memberList)
                if (member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().equals(input))) {
                    System.out.println("Information om \"" + input + "\":");
                    member.toString();
                    setMemberFoundIndex(memberList.indexOf(member));
                    return true;
                }
        } System.out.println("Personen hittades ej i medlemsregistret. Du skrev: " + input);
        return false;
    }
}

