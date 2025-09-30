package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private List<Double> grades;
    private int qtGrades;

    public Student(String name, int idade) {
        super(name, idade);
        this.grades = new ArrayList<>();
    }

    public List<Double> getGrades() {
        return grades;
    }

    public String getSituation(){
        double media = calculateAverage();
        if(media > 7){
            return "Approved.";
        }else{
            return "Failed.";
        }
    }

    public double getAverage(){
        return calculateAverage();
    }

    public void addGrade(double grade){
        grades.add(grade);
        qtGrades ++;
    }

    private double calculateAverage(){
        double sum = 0;
        for(double grade : grades){
            sum += grade;
        }
        return sum /qtGrades;
    }

    @Override
    public String toString() {
        return "Student - Name: " + getName() + " | Idade: " + getIdade() + " | Avg. Grade: " + String.format("%.2f",getAverage());
    }
}
