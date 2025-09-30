package models;

public class Book {
    private String name;
    private String author;
    private int numberOfPages;

    public Book(String name, String author, int numberOfPages) {
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public void showInformation(){
        String message = """
                Book: %s.
                Author: %s.
                Quantity: %d.
                """.formatted(name,author,numberOfPages);
        System.out.println(message);
    }
}
