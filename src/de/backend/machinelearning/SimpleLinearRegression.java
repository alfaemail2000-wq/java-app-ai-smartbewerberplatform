package de.backend.machinelearning;

/**
 * Einfache lineare Regression zur Vorhersage einer Zielgröße y anhand einer unabhängigen Variable x.
 * Das Modell hat die Form: y = w0 + w1 * x,
 * wobei w0 der Achsenabschnitt (Intercept) und w1 die Steigung (Slope) ist.
 */
public class SimpleLinearRegression {

    // Achsenabschnitt (Intercept)
    private double w0 = 0;

    // Steigung (Slope)
    private double w1 = 0;

    /**
     * Trainiert das Modell anhand der gegebenen Trainingsdaten.
     * Berechnet die Koeffizienten w0 und w1 mittels der Methode der kleinsten Quadrate.
     *
     * @param x unabhängige Variable (z.B. Jahre Erfahrung)
     * @param y abhängige Variable (z.B. Bewerberbewertung)
     */

    public void train(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0;

        // Summiere alle x- und y-Werte
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
        }

        // Berechne Mittelwerte von x und y
        double xMean = sumX / n;
        double yMean = sumY / n;

        double numerator = 0;    // Zähler für Steigungsformel
        double denominator = 0;  // Nenner für Steigungsformel

        // Berechnung von Steigung w1 und Achsenabschnitt w0
        for (int i = 0; i < n; i++) {
            numerator += (x[i] - xMean) * (y[i] - yMean);
            denominator += (x[i] - xMean) * (x[i] - xMean);
        }

        w1 = numerator / denominator;           // Steigung berechnen
        w0 = yMean - w1 * xMean;                // Achsenabschnitt berechnen
    }

    /**
     * Macht eine Vorhersage (Prediction) für einen gegebenen x-Wert.
     *
     * @param x der Eingabewert (z.B. Jahre Erfahrung)
     * @return die vorhergesagte Zielgröße y
     */
    public double predict(double x) {
        return w0 + w1 * x;
    }

    /**
     * Berechnet den mittleren quadratischen Fehler (Mean Squared Error, MSE)
     * zur Bewertung der Modellgüte anhand der Testdaten.
     *
     * @param x unabhängige Variable
     * @param y tatsächliche Zielwerte
     * @return mittlerer quadratischer Fehler
     */
    public double berechneMSE(double[] x, double[] y) {
        int n = x.length;
        double mse = 0;

        // Summiere die quadrierten Abweichungen zwischen Vorhersage und tatsächlichem Wert
        for (int i = 0; i < n; i++) {
            double prediction = predict(x[i]);
            mse += Math.pow(y[i] - prediction, 2);
        }

        // Mittelwert der quadrierten Fehler zurückgeben
        return mse / n;
    }

    /**
     * Gibt das trainierte Modell in der Form "y = w0 + w1 * x" auf der Konsole aus.
     */
    public void printModel() {
        System.out.printf("Modell: y = %.4f + %.4f * Erfahrung%n", w0, w1);
    }

    /*
    // (Optional) Schätzung der Wahrscheinlichkeit, basierend auf Erfahrung.
    // Beispiel für eine lineare Skalierung, geklemmt zwischen 0 und 100 %
    public double estimateProbability(double experience) {
        double probability = 5 * experience;
        return Math.min(100, Math.max(0, probability)); // Wert zwischen 0 und 100 begrenzen
    }
    */
}
