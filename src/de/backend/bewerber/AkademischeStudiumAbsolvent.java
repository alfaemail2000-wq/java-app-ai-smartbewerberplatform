package de.backend.bewerber;

/**
 * Interface AkademischeStudiumAbsolvent
 *
 * Dieses Interface kennzeichnet Bewerber, die ein akademisches Studium abgeschlossen haben.
 *
 * Passende Attribute (im Kommentar erwähnt) wären z.B. Berufsabschluss und Noten,
 * die in den implementierenden Klassen genutzt werden können.
 *
 * Methodendefinition:
 * - forschungBetreiben(): Eine abstrakte Methode, die das Forschen beschreibt.
 *   Klassen, die dieses Interface implementieren, müssen diese Methode mit
 *   einer konkreten Forschungsarbeit ausfüllen.
 */
public interface AkademischeStudiumAbsolvent {

    /**
     * Methode, die das Betreiben von Forschung beschreibt.
     * Die konkrete Umsetzung erfolgt in den implementierenden Klassen.
     */
    void forschungBetreiben();
}
