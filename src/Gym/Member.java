package Gym;

public class Member {
    protected String personalIdNumber;
    protected String name;
    protected String lastPaymentDate;
    protected String lastVisitDate;


    public Member(String personalIdNumber, String name, String lastPaymentDate) {
        this.personalIdNumber = personalIdNumber;
        this.name = name;
        this.lastPaymentDate = lastPaymentDate;
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

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(String lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }
}
