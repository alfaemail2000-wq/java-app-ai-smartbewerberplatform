package de.tests;

import de.backend.machinelearning.SimpleLinearRegression;

public class LinearRegressionTest {
    public static void main(String[] args) {
        double[] erfahrung = {1, 5, 10, 20};
        double[] wahrscheinlichkeit = {0.1, 0.4, 0.7, 0.95};

        SimpleLinearRegression model = new SimpleLinearRegression();
        model.train(erfahrung, wahrscheinlichkeit);
        model.printModel();

        double mse = model.berechneMSE(erfahrung, wahrscheinlichkeit);
        System.out.printf("MSE: %.4f%n", mse);

        double test = 20;
        double prediction = model.predict(test);
        System.out.printf("Vorhersage für %.1f Jahre: %.2f%n", test, prediction);
    }
    }

