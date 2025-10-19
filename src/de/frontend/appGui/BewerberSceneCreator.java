package de.frontend.appGui;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.datenbank.BewerberJsonDatenbankUndService;
import de.backend.jobs.Job;
import de.backend.jobs.Jobs;
import de.backend.machinelearning.HardCodedProbabilities;
import de.backend.machinelearning.MultipleLinearRegression;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BewerberSceneCreator {

    private FrontEndGui mainApp;
    private BewerberJsonDatenbankUndService dbService;

    private Scene scene;
    private VBox bewerberBox;
    private ComboBox<Jobs> jobComboBox;

    private Map<Jobs, Job> jobMap;

    private MultipleLinearRegression regressionModel = new MultipleLinearRegression();
    private HardCodedProbabilities hardcodedProbs = new HardCodedProbabilities();

    public BewerberSceneCreator(FrontEndGui mainApp, BewerberJsonDatenbankUndService dbService) {
        this.mainApp = mainApp;
        this.dbService = dbService;

        initJobMap();

        VBox root = new VBox(15);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Bewerber Übersicht");
        title.setFont(new Font(20));

        jobComboBox = new ComboBox<>();
        jobComboBox.getItems().addAll(Jobs.values());
        jobComboBox.setPromptText("Wähle einen Job");

        Button btnAlleBewerber = new Button("Alle Bewerber anzeigen");
        btnAlleBewerber.setOnAction(e -> zeigeAlleBewerber());

        Button btnPassendeBewerber = new Button("Vergleiche Bewerber zum Job");
        btnPassendeBewerber.setOnAction(e -> zeigePassendeBewerber());

        Button btnZurueck = new Button("Zurück");
        btnZurueck.setOnAction(e -> mainApp.zeigeStartScene());

        HBox buttonBox = new HBox(10, btnAlleBewerber, btnPassendeBewerber, btnZurueck);
        buttonBox.setAlignment(Pos.CENTER);

        bewerberBox = new VBox(10);
        bewerberBox.setPadding(new Insets(10));
        ScrollPane scrollPane = new ScrollPane(bewerberBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(400);

        root.getChildren().addAll(title, jobComboBox, buttonBox, scrollPane);
        scene = new Scene(root, 600, 600);
    }

    private void initJobMap() {
        jobMap = new HashMap<>();
        jobMap.put(Jobs.ARZTHAUS, new Job(5, true, 50000, "Artzt"));
        jobMap.put(Jobs.INGENIERMASCHINEBAU, new Job(2, true, 60000, "Ingenieur"));
        jobMap.put(Jobs.TECHNIKERZEICHNER, new Job(5, false, 42000, "Techniker"));
        jobMap.put(Jobs.KRANKENSCHWESTERAMBULANT, new Job(3, false, 38000, "Krankenschwester"));
    }

    public Scene getScene() {
        return scene;
    }

    private void zeigeAlleBewerber() {
        bewerberBox.getChildren().clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<CharakterBewerberpool> alleBewerber = dbService.getAlleBewerber();

        if (alleBewerber.isEmpty()) {
            bewerberBox.getChildren().add(new Label("Keine Bewerber gefunden."));
            return;
        }

        double[] years = new double[alleBewerber.size()];
        double[] endnoten = new double[alleBewerber.size()];
        double[] probs = new double[alleBewerber.size()];

        for (int i = 0; i < alleBewerber.size(); i++) {
            CharakterBewerberpool b = alleBewerber.get(i);
            years[i] = b.getJahreBerufserfahrung();
            endnoten[i] = b.getEndbewerbernoten();
            probs[i] = hardcodedProbs.einstellungsWahrscheinlichkeit(b.getJahreBerufserfahrung());
        }

        for (CharakterBewerberpool b : alleBewerber) {
            VBox box = new VBox(5);
            box.setPadding(new Insets(10));
            box.setStyle("-fx-border-color: lightblue; -fx-border-width: 2; -fx-background-color: #F0F8FF;");

            box.getChildren().addAll(
                    new Label("🆔 ID: " + b.getBewerberId()),
                    new Label("👤 Name: " + b.getName()),
                    new Label("🧑 Beruf: " + b.getBeruf()),
                    new Label("💼 Erfahrung: " + b.getJahreBerufserfahrung() + " Jahre"),
                    new Label("📅 Abschluss: " + b.getAbschlussdatum().format(formatter)),
                    new Label("📊 Bewerbernote: " + b.getBewerbernote()),
                    new Label("➕ Extrapunkte: " + b.getExtrapunkte()),
                    new Label("🏆 Endnote: " + b.getEndbewerbernoten())
            );

            Label predictionLabel = new Label();

            // Button für 1 Feature
            Button btnTrain1 = new Button("📈 Erfolgswahrscheinlichkeit (Erfahrung)");
            btnTrain1.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-weight: bold;");
            btnTrain1.setOnAction(e -> {
                regressionModel.train(years, probs);
                double pred = regressionModel.predict(b.getJahreBerufserfahrung());
                predictionLabel.setText("📈 Prognose: " + String.format("%.2f", pred) + " %");
            });

            // Button für 2 Features
            Button btnTrain2 = new Button("📊 Erfolgswahrscheinlichkeit (Erfahrung + Endnote)");
            btnTrain2.setStyle("-fx-background-color: #5DADE2; -fx-text-fill: white; -fx-font-weight: bold;");
            btnTrain2.setOnAction(e -> {
                regressionModel.train(years, endnoten, probs);
                double pred = regressionModel.predict(b.getJahreBerufserfahrung(), b.getEndbewerbernoten());
                predictionLabel.setText("📊 Prognose (2 Merkmale): " + String.format("%.2f", pred) + " %");
            });

            // Löschbutton
            Button loeschenBtn = new Button("🗑 Löschen");
            loeschenBtn.setStyle("-fx-background-color: #E57373; -fx-text-fill: white; -fx-font-weight: bold;");
            loeschenBtn.setOnAction(e -> {
                dbService.loescheBewerberNachId(b.getBewerberId());
                dbService.speichern();
                zeigeAlleBewerber();
            });


            box.getChildren().addAll(btnTrain1, btnTrain2, predictionLabel);

            bewerberBox.getChildren().add(box);
            bewerberBox.getChildren().add(loeschenBtn);
        }
    }

    private void zeigePassendeBewerber() {
        bewerberBox.getChildren().clear();
        Jobs selectedEnumJob = jobComboBox.getValue();

        if (selectedEnumJob == null) {
            bewerberBox.getChildren().add(new Label("Bitte wähle zuerst einen Job aus."));
            return;
        }

        Job selectedJob = jobMap.get(selectedEnumJob);
        if (selectedJob == null) {
            bewerberBox.getChildren().add(new Label("Kein Job-Objekt für den ausgewählten Job gefunden."));
            return;
        }

        List<CharakterBewerberpool> passendeBewerber = dbService.findePassendeBewerberListe(selectedJob);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (CharakterBewerberpool b : passendeBewerber) {
            VBox box = new VBox(5);
            box.setPadding(new Insets(10));
            box.setStyle("-fx-border-color: green; -fx-background-color: #E8F5E9;");
            box.getChildren().addAll(
                    new Label("🆔 ID: " + b.getBewerberId()),
                    new Label("👤 Name: " + b.getName()),
                    new Label("🧑 Beruf: " + b.getBeruf()),
                    new Label("💼 Erfahrung: " + b.getJahreBerufserfahrung() + " Jahre"),
                    new Label("📅 Abschluss: " + b.getAbschlussdatum().format(formatter)),
                    new Label("📊 Bewerbernote: " + b.getBewerbernote()),
                    new Label("➕ Extrapunkte: " + b.getExtrapunkte()),
                    new Label("🏆 Endnote: " + b.getEndbewerbernoten())
            );
            bewerberBox.getChildren().add(box);
        }
    }
}
