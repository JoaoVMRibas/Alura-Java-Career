package br.com.myproject.models;

import com.google.gson.annotations.SerializedName;

public class AudiovisualContent implements Comparable<AudiovisualContent>{
    private String name;
    private int yearOfRelease;
    private boolean included;
    private int totalDurationMinutes;
    private double sumOfRating;
    private int qtOfReviews;

    public AudiovisualContent(String name, int yearOfRelease) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
    }

    public AudiovisualContent(AudiovisualContentOmdb contentOmdb) {
        this.name = contentOmdb.title();
        if(!contentOmdb.year().equals("N/A")) {this.yearOfRelease = Integer.parseInt(contentOmdb.year().substring(0,4));}
        if(!contentOmdb.runtime().equals("N/A")){
            String[] parts = contentOmdb.runtime().split(" ");
            this.totalDurationMinutes = Integer.parseInt(parts[0]);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getYearOfRelease() {
        return this.yearOfRelease;
    }

    public int getTotalDurationMinutes() {
        return totalDurationMinutes;
    }

    public double getAverageRatings() {
        return sumOfRating/ qtOfReviews;
    }

    public void addNewRating(double rating) {
        this.sumOfRating += rating;
        this.qtOfReviews++;
    }

    @Override
    public int compareTo(AudiovisualContent other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return """
                Name: %s
                Year of release: %d
                Is included: %b
                Rating: %.2f
                Number of reviews: %d
                Duration: %d min
                """.formatted(name,yearOfRelease, included, (sumOfRating/ qtOfReviews), qtOfReviews, totalDurationMinutes);
    }
}