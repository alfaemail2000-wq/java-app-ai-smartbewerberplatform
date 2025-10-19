package de.backend.service;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.dateischreibenlessen.DateiSchreiben;

/**
 * Klasse, die eine Bewerbungsrunde simuliert.
 *
 * Hier wird geprüft, ob ein Bewerber im Bewerbungsprozess "noch dabei" ist,
 * also erfolgreich die Runde besteht.
 *
 * Außerdem kann der erfolgreiche Bewerber mit einer ID versehen
 * und ggf. in einer Datei gespeichert werden.
 */
public class BewerbungsgesprächTournier {

    // Hilfsklasse zum Schreiben von Bewerberdaten in eine Datei
    DateiSchreiben dateiSchreiben = new DateiSchreiben();

    /**
     * Führt eine Bewerbungsrunde für einen einzelnen Bewerber durch.
     * Prüft, ob der Bewerber noch im Prozess ist und gibt entsprechend true/false zurück.
     *
     * @param bewerber Bewerber, der geprüft wird
     * @return true wenn Bewerber noch dabei ist, sonst false
     */
    public boolean bewerbungsrunde(CharakterBewerberpool bewerber) {
        if (bewerber.isNochDabei()) {
            // Bewerber bekommt eine eindeutige ID zugewiesen
            bewerber.assignBewerberId();
            // Ausgabe: Bewerber hat Runde erfolgreich bestanden
            System.out.println("************-Successfulbewerber-***********: " + bewerber.getName());
            return true;
        } else {
            // Ausgabe: Bewerber hat Runde nicht bestanden
            System.out.println("*************-Failedbewerber-***********: " + bewerber.getName());
            return false;
        }
    }

    /*
     * Beispiel-Methode für Bewerbungsrunde mit mehreren Bewerbern (Array),
     * z.B. zum Speichern in Datei (momentan auskommentiert).
     *
     * Falls gewünscht, kann diese Methode aktiviert und verwendet werden.
     */
/*
    public void bewerbungsrunde(CharakterBewerberpool[] bewerberarray) {
        for (int i = 0; i < bewerberarray.length; i++) {
            if (bewerberarray[i].isNochDabei()) {
                bewerberarray[i].assignBewerberId();
                int id = bewerberarray[i].getBewerberId();

                dateiSchreiben.erfolreicheBewerberSchreiben(bewerberarray[i].erstellenStatusinformation() + "BewerberID: " + id);
                System.out.println("Here implement save Bewerber in file: -Successfulbewerber- : " + bewerberarray[i].getName());
            } else {
                System.out.println("Here implement save Bewerber in file: -Failedbewerber- : " + bewerberarray[i].getName());
            }
        }
    }
*/

}

/*
 * Weitere Ideen (auskommentiert):
 * - Zufällig einen Job aus Enum Jobs auswählen
 * - Simuliere Probearbeitstag oder Bewerbungsgespräch
 *
 * Beispiel:
 * Random wuerfel = new Random();
 * int jobIndex = wuerfel.nextInt(Jobs.values().length);
 * System.out.println("This is MAIN jobname is:" + Jobs.values()[jobIndex]);
 */
