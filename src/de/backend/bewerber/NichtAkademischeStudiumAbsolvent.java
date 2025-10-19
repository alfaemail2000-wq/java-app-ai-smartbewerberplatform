package de.backend.bewerber;

/**
 * Interface NichtAkademischeStudiumAbsolvent
 *
 * Dieses Interface kennzeichnet Bewerber, die keinen akademischen Abschluss besitzen,
 * sondern eine nicht-akademische Ausbildung abgeschlossen haben.
 *
 * Attribute, die dazu passen würden, wären z.B. Ausbildungsabschluss oder Noten (hier nur als Kommentar erwähnt).
 *
 * Methodendefinition:
 * - praktischArbeiten(): Eine abstrakte Methode, die beschreibt,
 *   dass der Bewerber praktische Arbeiten durchführt.
 *   Die konkrete Implementierung muss in den Klassen erfolgen,
 *   die dieses Interface implementieren.
 */
public interface NichtAkademischeStudiumAbsolvent {

    /**
     * Methode zur Durchführung praktischer Arbeit.
     * Implementierende Klassen müssen diese Methode mit ihrem spezifischen Verhalten ausfüllen.
     */
    void praktischArbeiten ();
}
