package Gym;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class memberVisits extends MemberList {

    protected List<Member> memberVisitList = new ArrayList<>();
    protected List<LocalDate> visitDates = new ArrayList<>();

    protected void addMemberVisit (String input) {
        LocalDate date = Date.getCurrentDate();
        List<Member> memberList = createMemberList();
        for(Member member : memberList)
            if (member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().contains(input))) {
                try (BufferedWriter buf = Files.newBufferedWriter(FilePath.visitsFilePath)){
                    if(memberVisitList.contains(input)) {
                        member.lastVisitDate.add(date);
                        System.out.println("Hej1");
                        for (Member s : memberVisitList)
                            buf.write(String.valueOf(s));
                    } else {
                        Member mem = new Member(member.getPersonalIdNumber(), member.getName(),
                                member.getLastPaymentDate(), member.getActiveMember(), member.getLastVisitDate());
                        mem.setLastVisitDate(date);
                        mem.lastVisitDate.add(date);
                        memberVisitList.add(member);
                        System.out.println("Hej2");
                        for (Member s : memberVisitList)
                            buf.write(String.valueOf(s));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else
                System.out.println("Personen hittades ej i medlemsregistret. Du skrev: " + input);
    }
    protected void showAllMemberVisitsList() {
        for(Member member : memberVisitList) {
            System.out.println(member.getName() + ", " + member.getPersonalIdNumber() +
                    ", senaste betalningsdag: " + member.getLastPaymentDate());
        }
    }
}
