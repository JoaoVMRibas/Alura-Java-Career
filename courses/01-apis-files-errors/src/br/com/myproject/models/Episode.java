package br.com.myproject.models;

import br.com.myproject.interfaces.Rating;

public class Episode implements Rating {
    private int number;
    private String name;
    private Series series;
    private int likes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public int getRating() {
        if(this.likes > 80) {
            return 5;
        } else if (this.likes > 60) {
            return 4;
        } else if (this.likes > 40) {
            return 3;
        } else if (this.likes > 20) {
            return 2;
        } else {
            return 1;
        }
    }
}