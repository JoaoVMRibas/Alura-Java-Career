package br.com.myproject;

import br.com.myproject.models.AudiovisualContent;
import br.com.myproject.services.AudiovisualContentFileWriter;
import br.com.myproject.services.AudiovisualContentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AudiovisualContentService movieService = new AudiovisualContentService();
        AudiovisualContentFileWriter mediaWriter = new AudiovisualContentFileWriter();

        List<AudiovisualContent> contentList = new ArrayList<>();

        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                System.out.println("Enter a title:");
                String title = scanner.nextLine();
                if(title.equalsIgnoreCase("exit")) break;
                contentList.add(movieService.searchByTitle(title));
            }
            mediaWriter.writeFile("media.json",contentList);
        }
    }
}
