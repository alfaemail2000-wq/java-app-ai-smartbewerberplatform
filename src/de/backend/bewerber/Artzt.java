package de.backend.bewerber;

// Atribute: ArtztSkills: kann blutt druck messen, probearbeit

import java.time.LocalDate;

/**
 * Die Klasse Artzt repräsentiert einen Bewerbertyp mit medizinischem Hintergrund.
 * Ein Artzt kann sowohl akademische als auch nicht-akademische Qualifikationen haben.
 * Diese Klasse erweitert die Basisklasse CharakterBewerberpool und implementiert
 * zusätzlich die Schnittstellen für akademische und nicht-akademische Bewerber.
 */
public class Artzt extends CharakterBewerberpool implements AkademischeStudiumAbsolvent, NichtAkademischeStudiumAbsolvent {

    /**
     * Die durchschnittliche Anzahl an Patienten, die ein Arzt pro Jahr behandelt.
     * Wird für die Berechnung der Bewerberleistung verwendet.
     */
    static private int behandeltepatientenperjahr = 50;

    /**
     * Konstruktor mit Parametern, ruft den Konstruktor der Oberklasse auf,
     * um allgemeine Bewerberdaten zu setzen.
     *
     * @param name                    Name des Arztes
     * @param skill                   Fähigkeiten wie z. B. Blutdruck messen
     * @param jahreBerufserfahrung   Anzahl der Berufsjahre
     * @param beruf                   Berufsbezeichnung
     * @param abschlussdatum          Abschlussdatum des Studiums oder der Ausbildung
     */
    public Artzt(String name, String skill, int jahreBerufserfahrung, String beruf, LocalDate abschlussdatum) {
        super(name, skill, jahreBerufserfahrung, beruf, abschlussdatum);
    }

    /**
     * Leerer Standard-Konstruktor. Dieser ruft automatisch den
     * Standard-Konstruktor der Oberklasse auf.
     * Wird verwendet, wenn z. B. ein Objekt ohne Vorinitialisierung erzeugt wird.
     */
    public Artzt() {
        super(); // calls empty constructor from CharakterBewerberpool
    }

    /**
     * Diese Methode berechnet die Gesamtzahl an Patienten,
     * die der Arzt im Laufe seiner Berufsjahre behandelt hat.
     * Dafür wird die Anzahl der Berufsjahre mit einer konstanten
     * Rate multipliziert.
     *
     * @return Anzahl behandelter Patienten insgesamt
     */
    public int behandeltepatientenbehandeltAllgeein() {
        int behandeltepatienten = getJahreBerufserfahrung() * behandeltepatientenperjahr;
        //System.out.println(name+"ich bin der " +this.getClass().getSimpleName()+" und habe so viel patien:"+behandeltepatienten+ "-ich habe so viele Jahreerfahrung: "+setJahreBerufserfahrung(jahreBerufserfahrung));
        return behandeltepatienten;
    }

    /**
     * Implementierung der forschungBetreiben()-Methode aus dem Interface
     * AkademischeStudiumAbsolvent.
     * Ein Arzt forscht beispielsweise an einem medizinischen Institut.
     */
    @Override
    public void forschungBetreiben() {
        System.out.println("Der Arzt forscht an einer Krebsinstitut.");
    }

    /**
     * Implementierung der Methode aus dem Interface
     * NichtAkademischeStudiumAbsolvent.
     * Ein Arzt kann auch praktische Tätigkeiten ausführen, z. B. Geräte bedienen.
     */
    @Override
    public void praktischArbeiten() {
        System.out.println("ich bin der Artzt und kann auch was nicht Akademiker kann bzw praktischArbeiten an Geräte: ");
    }

    /**
     * Bewertungsmethode, die zurückgibt, wie viele Patienten ein Arzt insgesamt behandelt hat.
     * Diese Zahl wird als Bewerbernote verwendet.
     *
     * @return Bewerbernote basierend auf der Gesamtzahl behandelter Patienten
     */
    @Override
    public int getBewerbernote() {
        return this.behandeltepatientenbehandeltAllgeein();
    }

    /**
     * Methode zur Ausgabe von Statusinformationen eines Bewerbers.
     * Gibt an, ob der Bewerber (Arzt) noch im Auswahlverfahren ist
     * und zeigt seine Bewertung und seinen Namen an.
     *
     * @return Statusinformation als formatierter String
     */
    @Override
    public String erstellenStatusinformation() {
        String info = "";
        String klassnname = this.getClass().getSimpleName();
        info = info + "Dieser Bewerber ist: " + klassnname + " und heisst: " + name + ".\n";
        info = info + "hat aktuel Note: " + this.endbewerbernoten + "\n";
        info = info + "ist " + (nochDabei ? "ist noch im Bewerbungsrunde\n" : "Arzt leider weg\n");
        return info;
    }
}
