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
        MemberVisits mv = new MemberVisits();
        String memberInputData, memberInputRegister;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Ange namn (förnamn efternamn)" +
                    " eller personnummer (10 siffror) för att söka efter medlem.\nSkriv exit för att avsluta. ");
            while(input.hasNext()) {
                memberInputData = input.nextLine();
                boolean memberSearch = ml.searchMemberbyNameOrPersonalIdNumber(memberInputData);
                if(!memberSearch) {
                    break;
                } else {
                    System.out.print("Registrera besök för aktuell medlem? (Ja/Nej) ");
                    memberInputRegister = input.nextLine();
                    if(memberInputRegister.equalsIgnoreCase("ja")) {
                        mv.addMemberVisit(ml.getMemberInList(0));
                    }
                }
            }
        }
    }
}
