package de.tests;

import de.backend.machinelearning.MultipleLinearRegression;

public class MultipleLinearRegressionTest {
    public static void main(String[] args) {
        // Trainingsdaten
        double[] erfahrung = {1, 5, 10, 20};
        double[] endnote = {50, 60, 80, 100};
        double[] wahrscheinlichkeit = {0.2, 0.4, 0.7, 0.95}; // Zielwerte

        // Modell initialisieren und trainieren
        MultipleLinearRegression model = new MultipleLinearRegression();
        model.train(erfahrung, endnote, wahrscheinlichkeit);
        model.printModel();

        // Vorhersage für neuen Bewerber (z. B. 12 Jahre, Note 90)
        double vorhersage = model.predict(8,70);
        System.out.printf("Vorhersage für 12 Jahre / Note 90: %.4f%n", vorhersage);
    }
}
