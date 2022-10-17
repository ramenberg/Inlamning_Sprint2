//package Gym;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.nio.file.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CreateMemberList extends Member {
//
//    public CreateMemberList(String personalIdNumber, String name, String lastPaymentDate, String lastVisitDate) {
//        super(personalIdNumber, name, lastPaymentDate, lastVisitDate);
//    }
//
////    public List<Member> makeMemberList() {
////        String firstRow;
////        String[] splitter;
////        List<Member> memberList = new ArrayList<>();
////
////        try(BufferedReader buf = Files.newBufferedReader(filePath)) {
////            while((firstRow = buf.readLine()) != null) {
////                Member member = new Member();
////                memberList.add(member);
////                splitter = firstRow.split(",");
////                member.setPersonalIdNumber(splitter[0].trim());
////                member.setName(splitter[1].trim());
////                member.setLastPaymentDate(buf.readLine().trim());
////            }
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////        return memberList;
////    }
//}
