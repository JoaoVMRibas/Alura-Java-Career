package models;

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int idade, String subject) {
        super(name, idade);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher - Name: " + this.getName() + " | Idade: "+this.getIdade() + " | Subject: " + subject;
    }
}
