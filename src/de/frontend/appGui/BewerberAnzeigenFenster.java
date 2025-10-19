/*


package de.appGui;

import de.bewerber.CharakterBewerberpool;
import de.datenbank.BewerberJsonDatenbankUndService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class BewerberAnzeigenFenster {
    private Scene scene;
    private FrontEndGui mainApp;

    public BewerberAnzeigenFenster(FrontEndGui mainApp) {
        this.mainApp = mainApp;

        VBox inhalt = new VBox(15);
        inhalt.setPadding(new Insets(20));
        inhalt.setAlignment(Pos.TOP_LEFT);

        BewerberJsonDatenbankUndService service = new BewerberJsonDatenbankUndService();
        service.laden();
        List<CharakterBewerberpool> bewerberListe = service.getAlleBewerber();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (CharakterBewerberpool b : bewerberListe) {
            VBox box = new VBox(4);
            box.setStyle("-fx-padding: 10; -fx-border-color: #ccc; -fx-border-radius: 8; -fx-border-width: 1;");

            // ID und Name mit Icons
            box.getChildren().add(new Label("🆔 ID: " + b.getBewerberId()));
            String name = (b.getName() == null || b.getName().isEmpty()) ? "<kein Name>" : b.getName();
            box.getChildren().add(new Label("👤 Name: " + name));

            box.getChildren().add(new Label("🧑 Beruf: " + b.getBeruf()));
            box.getChildren().add(new Label("💼 Erfahrung: " + b.getJahreBerufserfahrung() + " Jahre"));
            box.getChildren().add(new Label("📅 Abschluss: " + b.getAbschlussdatum().format(formatter)));
            box.getChildren().add(new Label("📊 Bewerbernote: " + b.getBewerbernote()));
            box.getChildren().add(new Label("➕ Extrapunkte: " + b.getExtrapunkte()));
            box.getChildren().add(new Label("🏆 Endnote: " + b.getEndbewerbernoten()));

            // Löschen-Button
            Button loeschenBtn = new Button("🗑 Löschen");
            loeschenBtn.setOnAction(e -> {
                service.loescheBewerberNachId(b.getBewerberId());
                service.speichern();
                aktualisiereSzene(); // Szene neu laden
            });

            HBox bottomBox = new HBox(loeschenBtn);
            bottomBox.setAlignment(Pos.CENTER_RIGHT);
            bottomBox.setPadding(new Insets(5, 0, 0, 0));

            VBox kandidatBox = new VBox(box, bottomBox);
            kandidatBox.setStyle("-fx-background-color: #f9f9f9; -fx-background-radius: 8;");
            kandidatBox.setPadding(new Insets(10));
            kandidatBox.setSpacing(5);

            inhalt.getChildren().add(kandidatBox);
        }


        ScrollPane scrollPane = new ScrollPane(inhalt);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(10));

        Button zurueckButton = new Button("⬅ Zurück");
        zurueckButton.setOnAction(e -> mainApp.zeigeStartSzene());

        VBox root = new VBox(10, scrollPane, zurueckButton);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);

        scene = new Scene(root, 700, 500);
    }

    public Scene getScene() {
        return scene;
    }

    private void aktualisiereSzene() {
        BewerberAnzeigenFenster neu = new BewerberAnzeigenFenster(mainApp);
        mainApp.getPrimaryStage().setScene(neu.getScene());
    }
}


package de.appGui;

import de.bewerber.AkademischeStudiumAbsolvent;
import de.bewerber.CharakterBewerberpool;
import de.bewerber.NichtAkademischeStudiumAbsolvent;
import de.datenbank.BewerberJsonDatenbankUndService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class BewerberSceneCreator {
    private Scene scene;

    public BewerberSceneCreator(AppFrontendGUI app) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        Label headline = new Label("📋 Dynamisch geladene Bewerber");
        headline.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
        root.getChildren().add(headline);

        // Lade Bewerber dynamisch aus JSON
        BewerberJsonDatenbankUndService datenbank = new BewerberJsonDatenbankUndService();
        datenbank.laden(); // lädt bewerber.json
        List<CharakterBewerberpool> bewerberListe = datenbank.getAlleBewerber();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (CharakterBewerberpool b : bewerberListe) {
            VBox box = new VBox(5);
            box.setStyle("-fx-padding: 10; -fx-border-color: gray; -fx-border-width: 1;");
            String name = (b.getName() != null && !b.getName().isBlank()) ? b.getName() : "(Kein Name)";
            box.getChildren().add(new Label("👤 Name: " + name));
            box.getChildren().add(new Label("🧑 Beruf: " + b.getBeruf()));
            box.getChildren().add(new Label("💼 Erfahrung: " + b.getJahreBerufserfahrung() + " Jahre"));
            box.getChildren().add(new Label("📅 Abschluss: " + b.getAbschlussdatum().format(formatter)));
            box.getChildren().add(new Label("📊 Bewerbernote: " + b.getBewerbernote()));
            box.getChildren().add(new Label("➕ Extrapunkte: " + b.getExtrapunkte()));
            box.getChildren().add(new Label("🏆 Endnote: " + b.getEndbewerbernoten()));

            // Fähigkeiten je nach Interface
            if (b instanceof NichtAkademischeStudiumAbsolvent) {
                box.getChildren().add(new Label("🔧 Fähigkeiten:"));
                box.getChildren().add(new Label("  ✔️ Geräte bedienen"));
                box.getChildren().add(new Label("  ✔️ Anleitung befolgen"));
            }
            if (b instanceof AkademischeStudiumAbsolvent) {
                box.getChildren().add(new Label("📚 Akademische Fähigkeiten:"));
                box.getChildren().add(new Label("  ✔️ Projekt leiten"));
                box.getChildren().add(new Label("  ✔️ Forschen"));
                box.getChildren().add(new Label("  ✔️ Rechnen"));
            }

            root.getChildren().add(box);
        }

        // Zurück-Button
        Button zurueckButton = new Button("⬅️ Zurück zur Startseite");
        zurueckButton.setOnAction(e -> app.zeigeStartScene());
        root.getChildren().add(zurueckButton);

        scene = new Scene(root, 600, 700);
    }

    public Scene getScene() {
        return scene;
    }
}


*/
