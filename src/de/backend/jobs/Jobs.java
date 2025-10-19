package de.backend.jobs;

/**
 * Enum, das verschiedene Job-Typen mit ihren Eigenschaften wie Mindestberufserfahrung,
 * Abschlussart (akademisch oder nicht-akademisch) und Gehalt definiert.
 *
 * Diese statische Datenbank ermöglicht eine einfache Verwaltung und Abfrage von Job-Informationen.
 */
public enum Jobs {

    // Definition der Jobs mit: Mindestberufserfahrung, Abschlussart (true=akademisch, false=nicht-akademisch), und Gehalt

    ARZTHAUS(5, true, 50000),
    INGENIERMASCHINEBAU(2, true, 60000),
    TECHNIKERZEICHNER(5, false, 42000),
    KRANKENSCHWESTERAMBULANT(3, false, 38000);

    // Mindestanforderung an Jahre der Berufserfahrung für den Job
    public int jahreBerufserfahrung;

    // Abschlussart des Jobs: true = akademischer Abschluss, false = nicht-akademisch
    public boolean abschlussArt;

    // Grundgehalt der jeweiligen Stelle
    public double stellenGehalt;

    // Standard-Gehalt für akademische Berufe (als Referenz)
    public static final double STANDARGEHALTAKADEMIKER = 60000;

    // Standard-Gehalt für nicht-akademische Berufe (als Referenz)
    public static final double STAQNDARTGEHALTNICHTAKADEMIKER = 45000;

    /**
     * Privater Konstruktor des Enums, der bei der Definition der Konstanten aufgerufen wird.
     *
     * @param berufserfahrung Mindestjahre der Berufserfahrung
     * @param abschluss Abschlussart (true = akademisch, false = nicht-akademisch)
     * @param gehalt Grundgehalt des Jobs
     */
    private Jobs(int berufserfahrung, Boolean abschluss, double gehalt) {
        this.jahreBerufserfahrung = berufserfahrung;
        this.abschlussArt = abschluss;
        this.stellenGehalt = gehalt;
    }

    /**
     * Getter für die Mindestjahre der Berufserfahrung.
     * @return Mindestjahre der Berufserfahrung
     */
    public int getMinErfahrung() {
        return jahreBerufserfahrung;
    }

    /**
     * Prüft, ob der Job einen akademischen Abschluss voraussetzt.
     * @return true, wenn akademisch, sonst false
     */
    public boolean isAkademisch() {
        return abschlussArt;
    }

    /**
     * Gibt das Grundgehalt der Stelle zurück.
     * @return Grundgehalt als double
     */
    public double getStellenGehalt() {
        return stellenGehalt;
    }

    /**
     * Gibt den Namen des Jobs zurück (Enum-Konstanten-Name).
     * @return Name des Jobs als String
     */
    public String getJobName() {
        return this.name();
    }

    /**
     * Berechnet das Monatsgehalt basierend auf der Berufserfahrung und Grundgehalt.
     * Für akademische Berufe wird pro Jahr Erfahrung 1000 Euro addiert,
     * für nicht-akademische 100 Euro pro Jahr.
     *
     * @return berechnetes Monatsgehalt
     */
    public double berechneMonatsGehalt() {
        double salary;
        if (abschlussArt == true) {
            salary = jahreBerufserfahrung * 1000 + stellenGehalt;
        } else {
            salary = jahreBerufserfahrung * 100 + stellenGehalt;
        }
        return salary;
    }
}
