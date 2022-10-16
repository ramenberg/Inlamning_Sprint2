package Gym;

public class Person {
    protected String personalIdNumber;
    protected String name;
    protected String lastPaymentDate;

    public Person(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    String lastVisitDate;

    public Person() {

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
    @Override
    public String toString() {
        return "Medlem: [Namn: " + name + ", Personnummer: " + personalIdNumber +
                ", Senaste betalningsdag: " + lastPaymentDate + "]";
    }
}
