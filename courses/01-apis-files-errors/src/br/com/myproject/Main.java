package br.com.myproject;

import br.com.myproject.models.AudiovisualContent;
import br.com.myproject.models.Movie;
import br.com.myproject.models.Series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AudiovisualContent> audioVisualList = new ArrayList<>();

        AudiovisualContent movie = new Movie("Avatar",2009);
        AudiovisualContent movie2 = new Movie("Vingadores: Guerra Infinita", 2018);
        AudiovisualContent serie = new Series("Lost",2004);

        audioVisualList.add(movie);
        audioVisualList.add(movie2);
        audioVisualList.add(serie);

        System.out.println(audioVisualList);

        Collections.sort(audioVisualList);
        System.out.println(audioVisualList);

    }
}
