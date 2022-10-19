package Gym.OldFiles;

import Gym.Member;
import Gym.MemberList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class memberVisits_OLD extends MemberList {

    protected List<Member> memberVisitList = new ArrayList<>();
    protected List<LocalDate> visitDates = new ArrayList<>();

//    protected void addMemberVisit(String input) {
//        LocalDate date = Date.getCurrentDate();
//        List<Member> memberList = createMemberList();
//
//        try (BufferedWriter buf = Files.newBufferedWriter(FilePath.visitsFilePath)) {
//            for (Member member : memberList)
//                if ((member.getName().equalsIgnoreCase(input) || (member.getPersonalIdNumber().equals(input)))) {
//                    member.setLastVisitDate(date);
//                    buf.append(member.toStringVisits());
//                    System.out.println("Medlemsbesök registrerat. ");
//                    break;
//                } else
//                    System.out.println("Personen hittades ej i medlemsregistret eller" +
//                            " är ej en aktiv medlem.\nDu skrev: "+input);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    protected void showAllMemberVisitsList() {
        for(Member member : memberVisitList) {
            System.out.println(member.getName() + ", " + member.getPersonalIdNumber() +
                    ", senaste betalningsdag: " + member.getLastPaymentDate());
        }
    }
}
