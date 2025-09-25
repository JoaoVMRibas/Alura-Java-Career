package br.com.myproject.services;

import br.com.myproject.models.AudiovisualContent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AudiovisualContentFileWriter {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void writeFile(String fileName, List<AudiovisualContent> contentList){
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(gson.toJson(contentList));
        } catch (IOException e) {
            System.out.println("Exception sending request.");
            System.out.println(e.getMessage());
        }
    }
}
