package pl.lewandowski.bookapp.domain;

public class Person {
    private String id;
    private String firstName;
    private int yob;

    public Person(String firstName, int yob) {
        this.firstName = firstName;
        this.yob = yob;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", yob=" + yob +
                '}';
    }

}
