package Gym;

import java.util.Scanner;

public class MainProg {

    public MainProg() {

        MemberList ml = new MemberList();
        MemberVisits mv = new MemberVisits();
        ml.createMemberListReadFromFile();

        String inputFromScanner, memberInputAskedToRegisterVisitForActiveMember;
        Scanner userInput = new Scanner(System.in);

        while(true) {
            System.out.print("Ange namn (förnamn efternamn)" +
                    " eller personnummer (10 siffror) för att söka efter medlem.\nSkriv exit för att avsluta. ");
            while(true) {
                inputFromScanner = userInput.nextLine().trim();
                if(inputFromScanner.equalsIgnoreCase("exit"))
                    System.exit(1);
                else {
                    boolean memberFound = ml.searchMemberByNameOrPersonalIdNumber(inputFromScanner);
                    if(!memberFound) {
                        System.out.println("\nPersonen hittades ej i registret. Försök igen.\n");
                    } else {
                        Member found = ml.getFoundMemberInSearch();
                        if (found.getActiveMember()) {
                            System.out.print("Vill du registrera besök för aktuell person? (ja/nej) ");
                            memberInputAskedToRegisterVisitForActiveMember = userInput.nextLine().trim();
                            if ((memberInputAskedToRegisterVisitForActiveMember.equalsIgnoreCase("j")) ||
                                    memberInputAskedToRegisterVisitForActiveMember.equalsIgnoreCase("ja")) {
                                mv.addMemberVisit(found);
                                System.out.println("Besöket för " + found.getName() +
                                        " är registrerat.\n");
                            }
                            else {
                                System.out.println("Inget besök registrerades.\n");
                            }
                            break;
                        }
                    }
                } break;
            }
        }
    }

    public static void main(String[] args) {
        MainProg gym = new MainProg();
    }
}
