package de.frontend.appGui;

import de.backend.datenbank.BewerberJsonDatenbankUndService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Die Hauptklasse für das Frontend der GUI-Anwendung zur Verwaltung von Bewerbern.
 * Diese Klasse initialisiert die JavaFX-Oberfläche, lädt die Datenbank, zeigt Login/Start-Szenen an,
 * und ermöglicht den Übergang zu verschiedenen GUI-Ansichten.
 *
 * Hauptaufgaben:
 * - Initialisierung der Hauptbühne (Stage)
 * - Laden der Bewerberdatenbank aus JSON
 * - Anzeigen der Login-Szene beim Start
 * - Erstellen und Anzeigen der Startszene mit Navigation
 */
public class FrontEndGui extends Application {

    /**
     * Die Hauptbühne (Fenster) der Anwendung.
     */
    private Stage primaryStage;

    /**
     * Die Startszene mit Buttons zur Navigation.
     */
    private Scene startSzene;

    /**
     * Datenbankservice zum Laden und Speichern von Bewerbern (JSON-Datei).
     */
    private BewerberJsonDatenbankUndService dbService;

    /**
     * Startpunkt der JavaFX-Anwendung. Initialisiert Fenster, lädt Datenbank und zeigt Login-Ansicht.
     *
     * @param primaryStage Die Hauptbühne (Stage) von JavaFX.
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Smart Bewerberpool GUI");

        // Datenbank laden
        dbService = new BewerberJsonDatenbankUndService();
        dbService.laden();

        // Login-Szene anzeigen
        LoginSceneCreator login = new LoginSceneCreator(this);
        primaryStage.setScene(login.getScene());
        primaryStage.show();
    }

    /**
     * Zeigt die Startszene mit einem Button zum Anzeigen aller Bewerber.
     * Diese Szene wird nach erfolgreichem Login aufgerufen.
     */
    public void zeigeStartScene() {
        primaryStage.setScene(startSzene);
        VBox root = new VBox(20);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);

        Button zeigeBewerberBtn = new Button("Bewerber anzeigen");
        zeigeBewerberBtn.setOnAction(e -> zeigeBewerberSzene());

        HBox buttonBox = new HBox(10, zeigeBewerberBtn);
        buttonBox.setAlignment(Pos.CENTER);

        root.getChildren().add(buttonBox);

        startSzene = new Scene(root, 400, 300);
        startSzene.getStylesheets().add("file:resources/bewerberstyle.css"); // CSS-Styling laden
        primaryStage.setScene(startSzene);
    }

    /**
     * Wechselt zur Szene, in der alle Bewerber in einer Liste dargestellt werden.
     * Diese Ansicht bietet zusätzlich Optionen zur Interaktion und Visualisierung.
     */
    private void zeigeBewerberSzene() {
        BewerberSceneCreator creator = new BewerberSceneCreator(this, dbService);
        Scene scene = creator.getScene();
        scene.getStylesheets().add("file:resources/bewerberstyle.css"); // Styling anwenden
        primaryStage.setScene(scene);
    }

    /**
     * Startmethode der Anwendung. Wird vom JVM-Launcher aufgerufen.
     *
     * @param args Programmargumente (nicht genutzt).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
