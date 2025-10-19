package de.backend.bewerber;

import java.time.LocalDate;

/**
 * Die Klasse Interviewer erweitert CharakterBewerberpool.
 * Ein Interviewer kann die Bewerber bewerten, indem er die Bewertungsmethode überschreibt.
 * Diese Klasse erbt alle Felder und Methoden von CharakterBewerberpool.
 */
public class Interviewer extends CharakterBewerberpool {

    /**
     * Konstruktor für Interviewer.
     * Ruft den Konstruktor der Elternklasse auf, um Basisdaten zu setzen.
     *
     * @param name                Name des Interviewers
     * @param skill               Fachliche oder soziale Kompetenzen
     * @param jahreBerufserfahrung Berufserfahrung in Jahren
     * @param beruf               Berufsbezeichnung des Interviewers
     * @param abschlussdatum      Datum des Studienabschlusses oder ähnliches
     */
    public Interviewer(String name, String skill, int jahreBerufserfahrung, String beruf, LocalDate abschlussdatum) {
        super(name, skill, jahreBerufserfahrung, beruf, abschlussdatum);
    }

    /**
     * Überschreibt die Bewertungsmethode aus der Elternklasse.
     * Statt eine neue Bewertung zu berechnen, wird die Methode von super aufgerufen
     * und zusätzlich wird die Note einfach ausgegeben.
     * Hinweis: Diese Methode verändert nicht die Logik, sondern ergänzt nur eine Konsolenausgabe.
     *
     * @param bewerbernote Note des Bewerbers vor Extrapunkten
     * @return Die unveränderte bewerbernote (nicht die Endbewertung!)
     */
    @Override
    public int bewerberNoteBewertung(int bewerbernote) {
        // Führt die Original-Bewertung der Elternklasse durch
        super.bewerberNoteBewertung(bewerbernote);

        // Gibt Debug-Information in der Konsole aus
        System.out.println("endbewerbernote in BewerberNoteBewertung() muss mehr als 70 % punkte : " + bewerbernote + "%");

        // Gibt NICHT die finale Endbewertung zurück, sondern nur die Eingabenote
        return bewerbernote;
    }
}
