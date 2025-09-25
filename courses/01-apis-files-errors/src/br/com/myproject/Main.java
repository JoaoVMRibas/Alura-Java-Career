package br.com.myproject;

import br.com.myproject.models.AudiovisualContent;
import br.com.myproject.models.AudiovisualContentOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<AudiovisualContent> mediaList = new ArrayList<>();
        String movie = "";

        try(Scanner scanner = new Scanner(System.in);){
            while(!movie.equalsIgnoreCase("exit")){

                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .setPrettyPrinting()
                        .create();

                System.out.println("Enter a movie:");
                movie = scanner.nextLine();
                if(movie.equalsIgnoreCase("exit")) break;

                try(HttpClient client = HttpClient.newHttpClient()) {
                    Config config = new Config("courses/01-apis-files-errors/config/config.properties");
                    String apiKey = config.get("API_KEY");

                    String encodedName = URLEncoder.encode(movie, StandardCharsets.UTF_8);
                    String uri = String.format("https://www.omdbapi.com/?t=%s&apikey=%s",encodedName,apiKey);
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(uri))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();

                    AudiovisualContentOmdb contentOmdb = gson.fromJson(json, AudiovisualContentOmdb.class);
                    AudiovisualContent content = new AudiovisualContent(contentOmdb);
                    mediaList.add(content);
                } catch (IOException | InterruptedException error){
                    System.out.println("Error sending request.");
                    System.out.println(error.getMessage());
                } catch (NumberFormatException e){
                    System.out.println("Error trying to convert a string to a number, string with invalid format.");
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println(mediaList);
    }
}
