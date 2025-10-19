package de.backend.machinelearning;

public class MultipleLinearRegression {

    private double w0 = 0;
    private double w1 = 0;
    private double w2 = 0;

    // Für 2 Features
    public void train(double[] erfahrung, double[] endnote, double[] y) {
        int n = erfahrung.length;

        double meanX1 = mean(erfahrung);
        double meanX2 = mean(endnote);
        double meanY = mean(y);

        double sxx1 = 0, sxx2 = 0, sxy1 = 0, sxy2 = 0;

        for (int i = 0; i < n; i++) {
            double dx1 = erfahrung[i] - meanX1;
            double dx2 = endnote[i] - meanX2;
            double dy = y[i] - meanY;

            sxx1 += dx1 * dx1;
            sxx2 += dx2 * dx2;

            sxy1 += dx1 * dy;
            sxy2 += dx2 * dy;
        }

        w1 = sxy1 / sxx1;
        w2 = sxy2 / sxx2;
        w0 = meanY - w1 * meanX1 - w2 * meanX2;
    }

    // Für 1 Feature
    public void train(double[] erfahrung, double[] y) {
        int n = erfahrung.length;

        double meanX = mean(erfahrung);
        double meanY = mean(y);

        double sxx = 0, sxy = 0;

        for (int i = 0; i < n; i++) {
            double dx = erfahrung[i] - meanX;
            double dy = y[i] - meanY;

            sxx += dx * dx;
            sxy += dx * dy;
        }

        w1 = sxy / sxx;
        w2 = 0; // Zweites Feature ungenutzt
        w0 = meanY - w1 * meanX;
    }

    public double predict(double erfahrung, double endnote) {
        return w0 + w1 * erfahrung + w2 * endnote;
    }

    public double predict(double erfahrung) {
        return w0 + w1 * erfahrung;
    }

    public void printModel() {
        System.out.printf("Modell: y = %.4f + %.4f * erfahrung + %.4f * endnote%n", w0, w1, w2);
    }

    private double mean(double[] arr) {
        double sum = 0;
        for (double v : arr) sum += v;
        return sum / arr.length;
    }
}
