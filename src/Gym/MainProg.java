package Gym;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class MainProg {
    /*
     * 1. be användaren att skriva in namn eller personnummer(10 siffror) ok/cancel
     * 2a. läsa filen och skriva ut info om medlemmen ok ->1 /cancel exit
     * 2b om medlem har aktivt medlemskap: fråga om besök ska registeras yes-> 3/no ->1/cancel exit
     * 2c om medlemmen inte hittas, meddela och börja om på 1
     * 3 skriva medlemsuppgifter + besöksdatum till fil ok -> 1
     * 4 cancel -> ext
     * */
    public static void main(String[] args) {

        MemberList ml = new MemberList();
        ml.createMemberList();
        MemberVisits mv = new MemberVisits();
        String memberInputData, memberInputRegister;
        Scanner input = new Scanner(System.in);
//        for (Member m : list)
//            if(m.activeMember)
//                mv.addMemberVisit(m);

        while(true) {
            System.out.print("Ange namn (förnamn efternamn)" +
                    " eller personnummer (10 siffror) för att söka efter medlem.\nSkriv exit för att avsluta. ");
            while(true) {
                memberInputData = input.nextLine().trim();
                if(memberInputData.equalsIgnoreCase("exit"))
                    System.exit(1);
                else {
                    boolean memberFound = ml.searchMemberbyNameOrPersonalIdNumber(memberInputData);
                    if(!memberFound) {
                        System.out.println("\nPersonen hittades ej i registret. Försök igen.\n");
                        break;
                    } else {
                        Member found = ml.getFoundMember();
                        if (found.getActiveMember()) {
                            System.out.print("Vill du registrera besök för aktuell person? (ja/nej) ");
                            memberInputRegister = input.nextLine().trim();
                            if (memberInputRegister.equalsIgnoreCase("nej")) {
                            }
                            else {
                                mv.addMemberVisit(found);
                                System.out.println("Besöket för " + found.getName() +
                                        " är registrerat.\n");
                            }
                            break;
                        }
                    }
                } break;
            }
        }

//        while (true) {
//            System.out.print("Ange namn (förnamn efternamn)" +
//                    " eller personnummer (10 siffror) för att söka efter medlem.\nSkriv exit för att avsluta. ");
//            while(true) {
//                memberInputData = input.nextLine();
//                if(memberInputData.equalsIgnoreCase("exit"))
//                    System.exit(1);
//                ml.searchMemberbyNameOrPersonalIdNumber(memberInputData);
////                if(!memberSearchFound) {
////                    System.out.println("Hittades ej. \n");
////                    break;
////                } else {
////                    System.out.print("Registrera besök för aktuell medlem? (Ja/Nej) ");
////                    memberInputRegister = input.nextLine();
////                    if(memberInputRegister.equalsIgnoreCase("ja")) {
////                        mv.addMemberVisit(ml.getFoundMember());
////                    } else {
////                        break;
////                    }
////                }
//            }
//        }
    }
}
