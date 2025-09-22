package br.com.myproject;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is Screen Match");

        String movieName = "Top Gun: Maverick";
        int yearOfRelease = 2022;
        boolean included = true;
        double movieRating = 4.9;
        String synopsis = "Adventure film.";

        String introduction = """
                Movie: %s
                Year of release: %d
                Included: %b
                Movie Rating: %.2f
                Synopsis: %s
                """.formatted(movieName,yearOfRelease,included, movieRating, synopsis);
        System.out.println(introduction);
    }
}
