import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerAPI {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(6767), 0);
        server.createContext("/api/bewerber", new BewerberHandler());
        server.setExecutor(null); // default executor
        server.start();
        System.out.println("Server läuft auf http://localhost:6767");
    }

    static class BewerberHandler implements HttpHandler {
        private final String dateiPfad = "bewerber.json";

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();

            switch (method) {
                case "GET" -> handleGet(exchange);
                case "POST" -> handlePost(exchange);
                default -> {
                    exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                }
            }
        }

        private void handleGet(HttpExchange exchange) throws IOException {
            File jsonFile = new File(dateiPfad);
            if (!jsonFile.exists()) {
                Files.write(Paths.get(dateiPfad), "[]".getBytes());
            }

            String query = exchange.getRequestURI().getQuery(); // z. B. "id=2"
            String json = new String(Files.readAllBytes(Paths.get(dateiPfad)));

            if (query != null && query.startsWith("id=")) {
                int gesuchteId = Integer.parseInt(query.split("=")[1]);
                // Einfache manuelle Suche nach BewerberId
                int index = json.indexOf("\"bewerberId\" : " + gesuchteId);
                if (index >= 0) {
                    int objStart = json.lastIndexOf("{", index);
                    int objEnd = json.indexOf("}", index) + 1;
                    String bewerberObj = json.substring(objStart, objEnd);

                    // Einzeln zurückgeben
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, bewerberObj.getBytes().length);
                    exchange.getResponseBody().write(bewerberObj.getBytes());
                    exchange.getResponseBody().close();
                    return;
                } else {
                    String msg = "{\"error\":\"Bewerber mit ID " + gesuchteId + " nicht gefunden\"}";
                    exchange.sendResponseHeaders(404, msg.length());
                    exchange.getResponseBody().write(msg.getBytes());
                    exchange.getResponseBody().close();
                    return;
                }
            }

            // Fallback: Alle Bewerber
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, json.getBytes().length);
            exchange.getResponseBody().write(json.getBytes());
            exchange.getResponseBody().close();
        }


        private void handlePost(HttpExchange exchange) throws IOException {
            InputStream is = exchange.getRequestBody();
            String neuerBewerber = new String(is.readAllBytes());

            // Alte Daten laden
            File jsonFile = new File(dateiPfad);
            if (!jsonFile.exists()) {
                Files.write(Paths.get(dateiPfad), "[]".getBytes());
            }

            String jsonAlt = new String(Files.readAllBytes(Paths.get(dateiPfad))).trim();
            String jsonNeu;

            if (jsonAlt.equals("[]")) {
                jsonNeu = "[" + neuerBewerber + "]";
            } else {
                jsonNeu = jsonAlt.substring(0, jsonAlt.length() - 1) + "," + neuerBewerber + "]";
            }

            Files.write(Paths.get(dateiPfad), jsonNeu.getBytes());

            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write("Bewerber gespeichert.".getBytes());
            os.close();
        }
    }
}
