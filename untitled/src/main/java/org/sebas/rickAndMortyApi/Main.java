package org.sebas.rickAndMortyApi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Optional<Character> character = getCharacter(1);
        Optional<Location> location = getLocation(2);
        System.out.println(character.get().getName());

    }


    public static Optional<Character> getCharacter(int value) throws IOException, InterruptedException {
        URI uri = URI.create("https://rickandmortyapi.com/api/character/" + value);
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Optional.of(objectMapper.readValue(response.body(), Character.class));
    }
    public static Optional<Location>  getLocation(int value) throws IOException, InterruptedException {
        URI uri = URI.create("https://rickandmortyapi.com/api/location/" + value);
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Location location = objectMapper.readValue(response.body(), Location.class);
        return Optional.of(location);

    }

}
