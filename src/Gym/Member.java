package Gym;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Member implements MemberVisitsInterface {
    protected String personalIdNumber;
    protected String name;
    protected LocalDate lastPaymentDate;

    protected Boolean activeMember;

    protected LocalDate lastVisitDate;


    // Member constructors
    public Member(String personalIdNumber, String name, LocalDate lastPaymentDate, Boolean activeMember) {
        this.personalIdNumber = personalIdNumber;
        this.name = name;
        this.lastPaymentDate = lastPaymentDate;
        this.activeMember = activeMember;
    }
    public Member(String personalIdNumber, String name, LocalDate lastVisitDate) {
        this.personalIdNumber = personalIdNumber;
        this.name = name;
        this.lastVisitDate = lastVisitDate;
    }

    // Overrides
    @Override
    public String toString() {
        return "Namn: " + getName() +
                "\nPersonnummer: " + getPersonalIdNumber() +
                "\nSenaste betalningsdag: " + getLastPaymentDate() +
                "\nAktiv medlem: " + booleanToString(getActiveMember())+"\n";
    }
    @Override
    public String toStringVisits() {
        return getLastVisitDate() + " " + getName() + ", " + getPersonalIdNumber() + "\n";
    }
    public String booleanToString(boolean b) {
        return b ? "ja" : "nej";
    } // true/false till ja/nej

    // getters & setters
    public Boolean getActiveMember() {
        return activeMember;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public List<LocalDate> getLastVisitDate() {
        return Collections.singletonList(lastVisitDate);
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

}
