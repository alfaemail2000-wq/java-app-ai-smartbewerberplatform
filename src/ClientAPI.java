import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ClientAPI {

    public static void main(String[] args) throws Exception {
        int bewerberId = 3; // Beispiel-ID

        URL url = new URL("http://localhost:6767/api/bewerber?id=" + bewerberId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        System.out.println("Antwortcode: " + connection.getResponseCode());

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        System.out.println("Antwort vom Server:");

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
