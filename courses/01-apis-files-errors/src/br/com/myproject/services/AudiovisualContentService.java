package br.com.myproject.services;

import br.com.myproject.Config;
import br.com.myproject.models.AudiovisualContent;
import br.com.myproject.models.AudiovisualContentOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class AudiovisualContentService {
    private final String apiKey;
    AudiovisualContent content;

    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public AudiovisualContentService(){
        Config config = new Config("courses/01-apis-files-errors/config/config.properties");
        this.apiKey = config.get("API_KEY");
    }

    public AudiovisualContent searchByTitle(String title){
        try(HttpClient client = HttpClient.newHttpClient()) {

            String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);
            String uri = String.format("https://www.omdbapi.com/?t=%s&apikey=%s",encodedTitle,apiKey);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            AudiovisualContentOmdb contentOmdb = gson.fromJson(json, AudiovisualContentOmdb.class);
            content = new AudiovisualContent(contentOmdb);
        } catch (IOException | InterruptedException e){
            System.out.println("Exception sending request.");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Exception trying to convert a string to a number, string with invalid format.");
            System.out.println(e.getMessage());
        }
        return content;
    }
}
