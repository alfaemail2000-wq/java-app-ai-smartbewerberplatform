package de.backend.bewerber;

// Atributes: name, age, softskills, jare berufserfahrung
// Methods: aufgabenerledigen, sprechen

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 * Die Klasse CharakterBewerberpool repräsentiert einen allgemeinen Bewerber im Bewerberpool.
 * Sie enthält Eigenschaften wie Name, Beruf, Abschlussdatum, Skills und Berufserfahrung.
 * Die Klasse bietet außerdem Methoden zur Bewertung und Statusermittlung eines Bewerbers.
 */
public class CharakterBewerberpool extends Object {

    // Allgemeine Daten des Bewerbers
    protected String name;
    private String age; // Alter des Bewerbers (nicht verwendet)
    private String skill; // z.B. Softskills oder Fachkompetenzen
    protected int jahreBerufserfahrung; // Anzahl Jahre Berufserfahrung
    private String beruf; // Beruf, z. B. "Ingenieur", "Artzt"
    private LocalDate abschlussdatum; // Wann wurde das Studium abgeschlossen?

    // Statusdaten für den Bewerbungsprozess
    protected boolean nochDabei = true; // true = Bewerber ist noch im Pool
    protected int bewerbernote; // Basisbewertung
    protected int extrapunkte; // Zusatzpunkte basierend auf Erfahrung
    protected int endbewerbernoten; // Gesamtnote mit Bonus

    // Eindeutige Bewerber-ID (automatisch vergeben)
    private int ausgewaehlteBewerberId = 0;
    private static int globalBwerberIdCounter = 1; // statischer Zähler für ID-Vergabe

    /**
     * Gibt dem Bewerber eine ID, falls er noch keine hat.
     */
    public int assignBewerberId() {
        if (this.ausgewaehlteBewerberId == 0) {
            this.ausgewaehlteBewerberId = globalBwerberIdCounter++;
        }
        return ausgewaehlteBewerberId;
    }

    /**
     * Gibt die aktuelle Bewerber-ID zurück.
     */
    public int getBewerberId() {
        return ausgewaehlteBewerberId;
    }

    /**
     * Konstruktor mit Parametern zur Initialisierung eines Bewerbers.
     * Die Berufserfahrung wird zufällig überschrieben.
     */
    public CharakterBewerberpool(String name, String skill, int jahreBerufserfahrung, String beruf, LocalDate abschlussdatum) {
        this.name = name;
        this.skill = skill;
        this.jahreBerufserfahrung = jahreBerufserfahrung;
        this.beruf = beruf;
        this.abschlussdatum = abschlussdatum;

        // Berufserfahrung zufällig zwischen 1 und 19 setzen
        Random wurwel = new Random();
        jahreBerufserfahrung = wurwel.nextInt(1, 20);

        // Sofort bewerten
        bewerberBewerten(this);
    }

    /**
     * Konstruktor ohne Parameter, setzt nur zufällige Berufserfahrung.
     */
    public CharakterBewerberpool() {
        Random wurwel = new Random();
        jahreBerufserfahrung = wurwel.nextInt(1, 20);
    }

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    /**
     * Berechnet Zusatzpunkte basierend auf Berufserfahrung.
     * - < 5 Jahre → 20 Punkte
     * - > 5 Jahre → 30 Punkte
     * - genau 5 Jahre → 10 Punkte
     */
    public int extraPunktErfahrung(int jahreBerufserfahrung) {
        if (jahreBerufserfahrung < 5) {
            extrapunkte = 2 * 10;
        } else if (jahreBerufserfahrung > 5) {
            extrapunkte = 3 * 10;
        } else {
            extrapunkte = 1 * 10;
        }
        return extrapunkte;
    }

    public int getJahreBerufserfahrung() {
        return this.jahreBerufserfahrung;
    }

    public String getBeruf() {
        return beruf;
    }

    public LocalDate getAbschlussdatum() {
        return abschlussdatum;
    }

    public void setBewerberId(int ausgewaehlteBewerberId) {
        this.ausgewaehlteBewerberId = ausgewaehlteBewerberId;
    }

    /**
     * Getter für Extrapunkte – berechnet sie bei Aufruf neu.
     */
    public int getExtrapunkte() {
        int ep = this.extraPunktErfahrung(this.getJahreBerufserfahrung());
        this.extrapunkte = ep;
        return ep;
    }

    /**
     * Gibt die rohe Bewerbernote zurück, z.B. wie viele Projekte etc.
     */
    public int getBewerbernote() {
        return this.bewerbernote;
    }

    /**
     * Gibt die finale Bewertung zurück – mit Bonuspunkten.
     */
    public int getEndbewerbernoten() {
        return endbewerbernoten;
    }

    /**
     * Berechnet finale Bewertung: 10 % von bewerbernote + extrapunkte.
     * Wenn Ergebnis unter 70 ist, gilt der Bewerber als ausgeschieden.
     */
    public int bewerberNoteBewertung(int bewerbernote) {
        endbewerbernoten = (int) ((bewerbernote * 0.10) + this.extrapunkte);

        if (endbewerbernoten < 70) {
            nochDabei = false;
            endbewerbernoten = 5555; // Marker für ausgeschieden
        }
        return endbewerbernoten;
    }

    /**
     * Bewertet den Bewerber (gibt die Endbewertung zurück).
     */
    public int bewerberBewerten(CharakterBewerberpool bewerber) {
        System.out.println("Extrapunkte aus CharakterBewerberpool: " + this.getExtrapunkte());
        int note = bewerber.getBewerbernote();
        int result = bewerber.bewerberNoteBewertung(note);
        return result;
    }

    /**
     * Erstellt Statusinformationen zum Bewerber (als String).
     */
    public String erstellenStatusinformation() {
        String statusInfo = "";
        statusInfo = "Der Bewerber hat Bewerbungsnote : " + bewerbernote;
        statusInfo = "Der Bewerber hat so viele Extrapunkte: " + extrapunkte;
        statusInfo = statusInfo + "Noch dabei" + nochDabei;
        statusInfo = statusInfo + (nochDabei ? "Der bewerber ist noch dabei ins Bewerberpool\n" : "leider nicht mehr dabei bei Bewerberpool");
        return statusInfo;
    }

    /**
     * Gibt zurück, ob der Bewerber noch im Auswahlverfahren ist.
     */
    public boolean isNochDabei() {
        return nochDabei;
    }

    /**
     * Zwei Bewerber gelten als gleich, wenn alle relevanten Felder gleich sind.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CharakterBewerberpool bewerber = (CharakterBewerberpool) o;
        return jahreBerufserfahrung == bewerber.jahreBerufserfahrung &&
                ausgewaehlteBewerberId == bewerber.ausgewaehlteBewerberId &&
                Objects.equals(name, bewerber.name) &&
                Objects.equals(skill, bewerber.skill) &&
                Objects.equals(beruf, bewerber.beruf) &&
                Objects.equals(abschlussdatum, bewerber.abschlussdatum);
    }

    /**
     * Berechnet einen Hash-Code für HashMaps o.Ä.
     */
    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(skill);
        result = 31 * result + jahreBerufserfahrung;
        result = 31 * result + ausgewaehlteBewerberId;
        result = 31 * result + Objects.hashCode(beruf);
        result = 31 * result + Objects.hashCode(abschlussdatum);
        return result;
    }

    /**
     * Gibt das Objekt als lesbaren String aus – für Debugging.
     */
    @Override
    public String toString() {
        return "CharakterBewerberpool{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", skill='" + skill + '\'' +
                ", jahreBerufserfahrung=" + jahreBerufserfahrung +
                ", beruf='" + beruf + '\'' +
                ", abschlussdatum=" + abschlussdatum +
                ", nochDabei=" + nochDabei +
                ", bewerbernote=" + bewerbernote +
                ", extrapunkte=" + extrapunkte +
                ", endbewerbernoten=" + endbewerbernoten +
                ", ausgewaehlteBewerberId=" + ausgewaehlteBewerberId +
                '}';
    }

    /**
     * Überschreibt die Anzahl Berufsjahre eines Bewerbers.
     */
    public int setJahreBerufserfahrung(int jahreBerufserfahrung) {
        return this.jahreBerufserfahrung = jahreBerufserfahrung;
    }
}
