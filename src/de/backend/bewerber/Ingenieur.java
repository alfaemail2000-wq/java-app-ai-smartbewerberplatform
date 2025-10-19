package de.backend.bewerber;

// Atribute: IngenieurSkills

import java.time.LocalDate;

/**
 * Die Klasse Ingenieur repräsentiert einen technischen Bewerber mit
 * akademischem Hintergrund. Ein Ingenieur bearbeitet technische Projekte
 * und wird anhand der Anzahl erfolgreicher Projekte bewertet.
 *
 * Diese Klasse erbt von CharakterBewerberpool und implementiert das Interface
 * AkademischeStudiumAbsolvent.
 */
public class Ingenieur extends CharakterBewerberpool implements AkademischeStudiumAbsolvent {

    // Enthält Namen des Bewerbers, obwohl dies bereits in der Elternklasse definiert ist
    private String name;

    // Konstante für durchschnittlich bearbeitete Projekte pro Jahr
    static private int behandelteprojekteimjahr = 50;

    /**
     * Konstruktor zur Initialisierung aller wichtigen Eigenschaften eines Ingenieurs.
     *
     * @param name                    Name des Bewerbers
     * @param skill                   Technische oder fachliche Fähigkeiten
     * @param jahreBerufserfahrung   Anzahl der Jahre Berufserfahrung
     * @param beruf                   Berufsbezeichnung, z. B. Maschinenbauingenieur
     * @param abschlussdatum         Datum des Studienabschlusses
     */
    public Ingenieur(String name, String skill, int jahreBerufserfahrung, String beruf, LocalDate abschlussdatum) {
        super(name, skill, jahreBerufserfahrung, beruf, abschlussdatum);
    }

    /**
     * Leerer Konstruktor, ruft den Standardkonstruktor der Basisklasse auf.
     * Wird verwendet, wenn das Objekt erst später befüllt wird.
     */
    public Ingenieur() {
        super();
    }

    /**
     * Berechnet, wie viele technische Projekte der Ingenieur
     * insgesamt während seiner Berufsjahre bearbeitet hat.
     *
     * @return Anzahl bearbeiteter Projekte
     */
    public int behandeltepProjektenAllgeein() {
        int behandelteprojekte = getJahreBerufserfahrung() * behandelteprojekteimjahr;
        //System.out.println(name+"ich bin der: " +this.getClass().getSimpleName()+ " und habe so viel projekten erschafft: "+behandelteprojekte+ "-ich habe so viele Jahreerfahrung: "+getJahreBerufserfahrung());
        return behandelteprojekte;
    }

    /**
     * Umsetzung der forschungBetreiben-Methode aus dem Interface AkademischeStudiumAbsolvent.
     * Beispiel: Der Ingenieur forscht an neuen technischen Innovationen.
     */
    @Override
    public void forschungBetreiben() {
        System.out.println("Der Ingenieur forscht an einer neuen Maschine.");
    }

    /**
     * Bewertungsmethode: Anzahl erfolgreich bearbeiteter Projekte wird
     * als Bewerbernote verwendet.
     *
     * @return Bewerbernote basierend auf Projektanzahl
     */
    @Override
    public int getBewerbernote() {
        return this.behandeltepProjektenAllgeein();
    }

    /**
     * Gibt eine formatierte Statusmeldung zum aktuellen Bewerber aus.
     * Beinhaltet Rolle, Name, aktuelle Bewertung und Bewerbungsstatus.
     *
     * @return Bewerberstatus als String
     */
    @Override
    public String erstellenStatusinformation() {
        String info = "";
        String klassnname = this.getClass().getSimpleName();
        info = info + "Dieser Bewerber ist: " + klassnname + " und heisst: " + name + ".\n";
        info = info + "hat aktuel Note: " + this.endbewerbernoten + "\n";
        info = info + "ist " + (nochDabei ? "ist noch im Bewerbungsrunde\n" : "Ingenie leider weg \n");
        return info;
    }
}
