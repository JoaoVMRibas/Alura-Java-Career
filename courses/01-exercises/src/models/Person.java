package models;

public abstract class Person {
    private String name;
    private int idade;

    public Person(String name, int idade) {
        this.name = name;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Name: "+name+" - Idade: "+idade;
    }
}