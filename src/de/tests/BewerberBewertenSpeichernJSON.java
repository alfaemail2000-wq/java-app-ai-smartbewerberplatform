package de.tests;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.bewerber.Interviewer;
import de.backend.datenbank.BewerberJsonDatenbankUndService;
import de.backend.datenbank.GenerateBewerber;
import de.backend.service.BewerbungsgesprächTournier;

import java.time.LocalDate;

/**
 * Hauptklasse zum Testen:
 *
 * Simuliert einen Bewerberprozess, bewertet einen zufälligen Bewerber
 * und speichert ihn bei Erfolg in der JSON-Datenbank (bewerber.json).
 */
public class BewerberBewertenSpeichernJSON {
    public static void main(String[] args) {
        // Erzeuge eine Referenz für einen generischen Bewerber (evtl. Platzhalter)
        CharakterBewerberpool personeReference = new CharakterBewerberpool();

        // Erzeuge Datenbank-Service und lade bestehende Bewerber aus JSON
        BewerberJsonDatenbankUndService db = new BewerberJsonDatenbankUndService();
        db.laden();

        // Erzeuge einen zufälligen Bewerber mit zufälligen Attributen
        GenerateBewerber bewerber = new GenerateBewerber();
        CharakterBewerberpool randombewerber = bewerber.generateRandomBewerber();

        // Erzeuge Interviewer, der den Bewerber bewertet
        Interviewer interviewer0 = new Interviewer("John", "bewerbertesten", 10, "HR", LocalDate.now());

        // Bewerbernote vom Interviewer bewerten (aktuell Ausgabe, 5555 = Fehlercode für failed Bewerber)
        System.out.println("1 RANDOM BEWERBER TEST: " + interviewer0.bewerberNoteBewertung(randombewerber.getEndbewerbernoten()) + "\n");

        // Erstelle Bewerbungsrunde-Service
        BewerbungsgesprächTournier interview0 = new BewerbungsgesprächTournier();

        // Starte Bewerbungsrunde mit dem zufälligen Bewerber
        interview0.bewerbungsrunde(randombewerber);

        // Falls Bewerber erfolgreich, füge ihn in DB hinzu und speichere
        if (interview0.bewerbungsrunde(randombewerber)) {
            db.bewerberHinzufuegen(randombewerber);
            db.speichern();
        } else {
            // Bewerber nicht erfolgreich, nicht speichern
            System.out.println("Bewerber failed and not saved in json DB");
        }
    }
}
