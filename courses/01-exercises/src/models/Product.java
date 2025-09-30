package models;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){
        this.name = name;
        if(price < 0) {
            System.out.println("Invalid price.");
            this.price = 0;
        } else{
            this.price = price;
        }
        this.quantity = quantity;
    }

    public void showInformation(){
        String message = """
                Name: %s.
                Price: %.2f.
                Quantity: %d.
                """.formatted(name,price,quantity);
        System.out.println(message);
    }
}
