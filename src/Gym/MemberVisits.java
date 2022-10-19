package Gym;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class MemberVisits extends MemberList {

    protected void addMemberVisit(Member member) {
        LocalDate date = Date.getCurrentDate();
        try (BufferedWriter buf = Files.newBufferedWriter(FilePath.visitsFilePath, StandardOpenOption.APPEND)) {
            member.setLastVisitDate(date);
            buf.append(member.toStringVisits()).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    protected void showAllMemberVisitsList() {
//        for (Member member : memberVisitList) {
//            System.out.println(member.getName() + ", " + member.getPersonalIdNumber() +
//                    ", senaste betalningsdag: " + member.getLastPaymentDate());
//        }
//    }
}
