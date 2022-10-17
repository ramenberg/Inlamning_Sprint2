package Gym;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberList {
    final Path filePath = Paths.get("src/Gym/customers.txt");
    final Path visitsFilePath = Paths.get("src/Gym/memberVisitDates.txt");
    protected List<Member> memberList = new ArrayList<>();
    protected List<String> memberVisitList = new ArrayList<>();

    protected void addMember(Member member) {
        memberList.add(member);
    }
    public void createMemberList() {
        String firstRow;
        String[] splitter;
        String name, pNr, paymentDate;

        try(BufferedReader buf = Files.newBufferedReader(filePath)) {
            while((firstRow = buf.readLine()) != null) {
                splitter = firstRow.split(",");
                pNr = (splitter[0].trim());
                name = (splitter[1].trim());
                paymentDate = (buf.readLine().trim());
                Member mem = new Member(pNr, name, paymentDate);
                addMember(mem);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void searchMemberbyNameOrPersonalIdNumber(String input) {
        for(Member member : memberList)
            if (member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().equalsIgnoreCase(input))) {
                System.out.println(member.getName() + ", " + member.getPersonalIdNumber() +
                        ", senaste betalningsdag: " + member.getLastPaymentDate());
            } else
                System.out.println("Personen hittades ej i medlemsregistret. Du skrev: " +input);
    }

    protected void showAllMemberList() {
        for(Member member : memberList) {
            System.out.println(member.getName() + ", " + member.getPersonalIdNumber() +
                    ", senaste betalningsdag: " + member.getLastPaymentDate());
        }
    }
//    protected void showMembersWithVisitDates() {
//        for(Member member : memberVisitList) {
//            System.out.println(member.getName() + ", " + member.getPersonalIdNumber() +
//                    ", besök: " + member.getLastVisitDate());
//        }
//    }
    protected void addMemberVisit (String input) {
        LocalDate date = Date.getCurrentDate();

        for(Member member : memberList)
            if (member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().contains(input))) {
                try (BufferedWriter buf = Files.newBufferedWriter(visitsFilePath)){
                    if(memberVisitList.contains(input)) {
                        member.setLastVisitDate(String.valueOf(date));
                        memberVisitList.add(member.lastVisitDate);
                        buf.write(memberVisitList.toString());
                    } else {
                        Member mem = new Member(member.getPersonalIdNumber(), member.getName(),
                                member.getLastPaymentDate());
                        mem.setLastVisitDate(String.valueOf(date));
                        memberVisitList.add(mem.lastVisitDate);
                        buf.write(memberVisitList.toString());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else
                System.out.println("Personen hittades ej i medlemsregistret. Du skrev: " + input);
    }

}
