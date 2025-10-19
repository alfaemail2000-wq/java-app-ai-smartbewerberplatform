package de.backend.machinelearning;

/**
 * Diese Klasse stellt hart codierte Wahrscheinlichkeiten für die Einstellung
 * in Abhängigkeit von den Berufsjahren bereit.
 *
 * Im Kontext eines Machine-Learning-Datensatzes:
 * - Die Berufserfahrung (Jahre) ist das Eingangs-Feature (x).
 * - Die Einstellungswahrscheinlichkeit ist das Ziel-Feature (y).
 *
 * Diese Werte können genutzt werden, um z.B. ein lineares Regressionsmodell
 * zu trainieren, das anhand von JSON-Daten aus Bewerberprofilen die Wahrscheinlichkeit
 * für eine Einstellung vorhersagt.
 */
public class HardCodedProbabilities {

    /**
     * Gibt die Wahrscheinlichkeit zurück, mit der ein Bewerber
     * mit der angegebenen Berufserfahrung eingestellt wird.
     *
     * @param jahre Anzahl der Jahre Berufserfahrung (Feature x)
     * @return Einstellungswahrscheinlichkeit in Prozent (Ziel y)
     */
    public double einstellungsWahrscheinlichkeit(double jahre) {
        if (jahre <= 0) return 1;
        if (jahre == 1) return 4;
        if (jahre == 2) return 9;
        if (jahre == 3) return 15;
        if (jahre == 4) return 22;
        if (jahre == 5) return 30;
        if (jahre == 6) return 39;
        if (jahre == 7) return 49;
        if (jahre == 8) return 58;
        if (jahre == 9) return 65;
        if (jahre == 10) return 72;
        if (jahre == 11) return 78;
        if (jahre == 12) return 83;
        if (jahre == 13) return 87;
        if (jahre == 14) return 90;
        if (jahre == 15) return 92;
        if (jahre == 16) return 94;
        if (jahre == 17) return 96;
        if (jahre == 18) return 97;
        if (jahre == 19) return 98;
        if (jahre >= 20) return 99;

        return 0;
    }
}
