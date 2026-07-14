import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Request example = new Request("Request","This is a test request", 101, 1);
        ObjectMapper oM = new ObjectMapper();
        String jsonExample = oM.writeValueAsString(example);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonExample))
                .build();

        HttpResponse<?> res = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (res.statusCode() == 201){
            System.out.println("The request was successfuly created");
        }else {
            System.out.println("Something went wrong");
        }
    }

}
