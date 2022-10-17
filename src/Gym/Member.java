package Gym;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Member {
    protected String personalIdNumber;
    protected String name;
    protected LocalDate lastPaymentDate;


    protected Boolean activeMember;

    protected List<LocalDate> lastVisitDate;


    public Member(String personalIdNumber, String name, LocalDate lastPaymentDate, Boolean activeMember) {
        this.personalIdNumber = personalIdNumber;
        this.name = name;
        this.lastPaymentDate = lastPaymentDate;
        this.activeMember = activeMember;
    }
    public Member(String personalIdNumber, String name, LocalDate lastPaymentDate, Boolean activeMember,
                  List<LocalDate> lastVisitDate) {
        this.personalIdNumber = personalIdNumber;
        this.name = name;
        this.lastPaymentDate = lastPaymentDate;
        this.activeMember = activeMember;
        this.lastVisitDate = lastVisitDate;
    }

    @Override
    public String toString() {
        return "Namn: " + getName() +
                "\nPersonnummer: " + getPersonalIdNumber() +
                "\nSenaste betalningsdag: " + getLastPaymentDate() +
                "\nAktiv medlem: " + getActiveMember() +"\n";
    }

    public Boolean getActiveMember() {
        return activeMember;
    }
    public void setActiveMember(Boolean activeMember) {
        this.activeMember = activeMember;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }
    public List<LocalDate> getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = Collections.singletonList(lastVisitDate);
    }
}
