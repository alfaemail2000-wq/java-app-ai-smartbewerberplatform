package de.backend.jobs;

/**
 * Repräsentiert einen Job mit Eigenschaften wie erforderliche Berufserfahrung,
 * Abschlussart, Gehalt und Jobbezeichnung.
 *
 * Diese Klasse dient als Datenmodell für Jobinformationen, die später für Bewerberabgleiche genutzt werden können.
 */
public class Job {

    // Mindestanforderung an die Jahre der Berufserfahrung für die Stelle
    public int jahreBerufserfahrung;

    // Art des erforderlichen Abschlusses (z.B. akademisch oder nicht-akademisch)
    // true oder false als Platzhalter, je nach Verwendung im System
    public boolean abschlussArt;

    // Gehalt für die ausgeschriebene Stelle
    public double stellenGehalt;

    // Name oder Bezeichnung des Jobs, z.B. "Arzt", "Ingenieur"
    public String name;

    /**
     * Konstruktor zur Initialisierung eines Job-Objekts mit allen Attributen.
     *
     * @param jahreBerufserfahrung Mindestjahre der Berufserfahrung
     * @param abschlussArt Art des erforderlichen Abschlusses (true/false)
     * @param stellenGehalt Gehalt der Stelle
     * @param name Bezeichnung des Jobs
     */
    public Job(int jahreBerufserfahrung, boolean abschlussArt, double stellenGehalt, String name) {
        this.jahreBerufserfahrung = jahreBerufserfahrung;
        this.abschlussArt = abschlussArt;
        this.stellenGehalt = stellenGehalt;
        this.name = name;
    }

    // Getter und Setter Methoden für alle Attribute

    /**
     * Liefert die erforderliche Anzahl an Berufsjahren für den Job.
     * @return Jahre Berufserfahrung
     */
    public int getJahreBerufserfahrung() {
        return jahreBerufserfahrung;
    }

    /**
     * Setzt die erforderliche Anzahl an Berufsjahren für den Job.
     * @param jahreBerufserfahrung Jahre Berufserfahrung
     */
    public void setJahreBerufserfahrung(int jahreBerufserfahrung) {
        this.jahreBerufserfahrung = jahreBerufserfahrung;
    }

    /**
     * Gibt zurück, welche Abschlussart für den Job erforderlich ist.
     * @return Abschlussart (true/false)
     */
    public boolean isAbschlussArt() {
        return abschlussArt;
    }

    /**
     * Setzt die Abschlussart für den Job.
     * @param abschlussArt Abschlussart (true/false)
     */
    public void setAbschlussArt(boolean abschlussArt) {
        this.abschlussArt = abschlussArt;
    }

    /**
     * Liefert das Gehalt der Stelle.
     * @return Gehalt als double
     */
    public double getStellenGehalt() {
        return stellenGehalt;
    }

    /**
     * Setzt das Gehalt der Stelle.
     * @param stellenGehalt Gehalt als double
     */
    public void setStellenGehalt(double stellenGehalt) {
        this.stellenGehalt = stellenGehalt;
    }

    /**
     * Gibt den Namen bzw. die Bezeichnung des Jobs zurück.
     * @return Name des Jobs
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen bzw. die Bezeichnung des Jobs.
     * @param name Name des Jobs
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Überschreibt die toString-Methode, um eine lesbare Darstellung des Jobs zu liefern.
     * @return String-Darstellung mit allen wichtigen Attributen
     */
    @Override
    public String toString() {
        return "Job{" +
                "jahreBerufserfahrung=" + jahreBerufserfahrung +
                ", abschlussArt=" + abschlussArt +
                ", stellenGehalt=" + stellenGehalt +
                ", name='" + name + '\'' +
                '}';
    }
}
