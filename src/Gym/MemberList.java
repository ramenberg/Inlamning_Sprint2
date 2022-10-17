package Gym;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    protected List<Member> memberList = new ArrayList<>();

    protected void addMember(Member member) {
        memberList.add(member);
    }
    public List<Member> createMemberList() {
        String firstRow;
        String[] splitter;
        String name, pNr;
        LocalDate paymentDate;
        boolean membershipValidation;

        try(BufferedReader buf = Files.newBufferedReader(FilePath.filePath)) {
            while((firstRow = buf.readLine()) != null) {
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
        if(paymentDate.isAfter(Date.getCurrentDateMinusOneYear())) {
            membershipValid = true;
        } else
            membershipValid = false;
        return membershipValid;
    }
    protected void searchMemberbyNameOrPersonalIdNumber(String input) {
        for(Member member : memberList)
            if (member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().equalsIgnoreCase(input))) {
                System.out.println("Information om " + input + ":");
                System.out.println(member);
            } else
                System.out.println("Personen hittades ej i medlemsregistret. Du skrev: " +input);
    }

    protected void showAllMemberList() {
        for(Member member : memberList) {
            System.out.println(member);
        }
    }
}
