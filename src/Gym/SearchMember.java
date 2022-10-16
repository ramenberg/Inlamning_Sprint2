package Gym;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class SearchMember extends CreateMemberList {

    public SearchMember() {
        // ange personnummer eller namn för att söka efter medlem - lägg i whilesats för att kunna avsluta
        List<Person> lista = makeMemberList();
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        String input = "8512021234";
        int index = 0;
        Person memberFound = null;


//        for (Person p : lista(0); {
//            ArrayList<Namn> namn = p.getName();
//            for(Namn n : namn) {
//                if (input.trim().equalsIgnoreCase(n)) {
//                    System.out.println("Hittades");
//                    index++;
//                    break;
//                }
//                // intern loop för att kolla medlemsavgift
//            } else {
//                System.out.println("Personen hittades ej i registret. ");
//            }



        }
        //sök först bland personnummer, sedan bland namn, ignorecase.
        // om funnen: spara index i listan

}
