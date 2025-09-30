package models;

public class Contact {
    private String name;
    private String telephone;

    public Contact(String name, String phone) {
        this.name = name;
        this.telephone = phone;
    }

    @Override
    public String toString() {
        return "Name: "+name+" - Phone: "+ telephone;
    }
}
