package de.frontend.appGui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

/**
 * Erstellt die Login-Oberfläche (Login-Szene) für die GUI-Anwendung.
 * Diese Szene beinhaltet einfache Benutzerauthentifizierung mit statischen Zugangsdaten
 * und ermöglicht den Zugang zur Hauptanwendung bei erfolgreichem Login.
 */
public class LoginSceneCreator {

    /**
     * Die erstellte JavaFX-Szene mit Login-Elementen.
     */
    private Scene scene;

    /**
     * Referenz auf die Hauptanwendung (FrontEndGui), um Szenenwechsel zu ermöglichen.
     */
    private FrontEndGui mainApp;

    /**
     * Konstruktor, der die Login-Oberfläche aufbaut und das Layout sowie das Login-Verhalten definiert.
     *
     * @param mainApp Die Hauptanwendung zur Navigation nach erfolgreichem Login.
     */
    public LoginSceneCreator(FrontEndGui mainApp) {
        this.mainApp = mainApp;

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Label title = new Label("Login");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Benutzername");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Passwort");

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        Button loginBtn = new Button("Einloggen");
        loginBtn.setOnAction(e -> {
            String user = usernameField.getText();
            String pass = passwordField.getText();

            if (isValid(user, pass)) {
                mainApp.zeigeStartScene(); // Weiterleitung zur Hauptszene
            } else {
                // Fehlermeldung bei ungültigen Zugangsdaten (derzeit auskommentiert)
                // messageLabel.setText("Falscher Benutzername oder Passwort.");
            }
        });

        root.getChildren().addAll(title, usernameField, passwordField, loginBtn, messageLabel);
        scene = new Scene(root, 400, 300);
    }

    /**
     * Überprüft die Gültigkeit der eingegebenen Zugangsdaten.
     * Aktuell werden statische Dummy-Daten verwendet: admin / 1234.
     *
     * @param username Der eingegebene Benutzername.
     * @param password Das eingegebene Passwort.
     * @return true, wenn Benutzername und Passwort korrekt sind, sonst false.
     */
    private boolean isValid(String username, String password) {
        // Dummy-Zugangsdaten zur Demonstration
        return username.equals("admin") && password.equals("1234");
    }

    /**
     * Gibt die erzeugte Login-Szene zurück.
     *
     * @return Die Scene mit Login-Layout.
     */
    public Scene getScene() {
        return scene;
    }
}
