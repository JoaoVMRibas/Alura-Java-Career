package br.com.myproject;

public class Main {
    public static void main(String[] args) {

        Config config = new Config("courses/01-apis-files-errors/config/config.properties");
        String apiKey = config.get("API_KEY");

        System.out.println("API_KEY = " + apiKey);
    }
}
