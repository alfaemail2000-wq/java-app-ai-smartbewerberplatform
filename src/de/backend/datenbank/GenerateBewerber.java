package de.backend.datenbank;

import de.backend.bewerber.Artzt;
import de.backend.bewerber.Ingenieur;
import de.backend.bewerber.Krankenschwester;
import de.backend.bewerber.CharakterBewerberpool;

import java.time.LocalDate;
import java.util.Random;

/**
 * Erzeugt zufällige, hardkodierte Bewerberobjekte zur Simulation.
 *
 * Diese Klasse generiert Bewerber aus verschiedenen Berufsklassen (Arzt, Ingenieur, Krankenschwester)
 * mit zufälligen Namen, Skills, Berufserfahrung und Abschlussdatum.
 */
public class GenerateBewerber {

    // Vordefinierte Arrays mit möglichen Namen und Skills
    private static final String[] names = {"Anna", "Tobias", "Maya", "Lukas", "Fatima", "Jonas"};
    private static final String[] skills = {"Kommunikation", "Organisation", "Teamarbeit", "Analyse"};

    // Mögliche Berufsbezeichnungen für die jeweiligen Berufsgruppen
    private static final String[] arztBerufe = {"Ärztin", "Zahnarzt", "Chirurg"};
    private static final String[] ingBerufe = {"Maschinenbau", "Bauingenieur", "Elektrotechnik"};
    private static final String[] krankenschwesterBerufe = {"Pflege", "Kinderstation", "Intensivpflege"};

    // Zufallsgenerator zum Erzeugen der Zufallswerte
    private static final Random random = new Random();

    /**
     * Generiert einen zufälligen Bewerber vom Typ Arzt, Ingenieur oder Krankenschwester.
     *
     * Dabei werden Name, Skill, Berufserfahrung und Abschlussdatum zufällig ausgewählt.
     * @return Ein zufällig erzeugtes Objekt der Klasse CharakterBewerberpool (konkret: Arzt, Ingenieur oder Krankenschwester)
     */
    public CharakterBewerberpool generateRandomBewerber() {
        // Zufällige Auswahl des Typs (0=Arzt, 1=Ingenieur, 2=Krankenschwester)
        int typ = random.nextInt(3);

        // Zufälliger Name aus names-Array
        String name = names[random.nextInt(names.length)];
        // Zufälliger Skill aus skills-Array
        String skill = skills[random.nextInt(skills.length)];
        // Zufällige Berufserfahrung zwischen 0 und 20 Jahren
        int erfahrung = random.nextInt(21);
        // Zufälliges Abschlussdatum (zwischen 2005 und 2024)
        LocalDate datum = LocalDate.of(2005 + random.nextInt(20), 1 + random.nextInt(12), 1 + random.nextInt(28));

        // Je nach Typ wird eine entsprechende Bewerber-Instanz erzeugt
        switch (typ) {
            case 0:
                System.out.println("Artzt generiert, Typ: " + typ);
                return new Artzt(name, skill, erfahrung, arztBerufe[random.nextInt(arztBerufe.length)], datum);
            case 1:
                System.out.println("Ingenieur generiert, Typ: " + typ);
                return new Ingenieur(name, skill, erfahrung, ingBerufe[random.nextInt(ingBerufe.length)], datum);
            case 2:
                System.out.println("Krankenschwester generiert, Typ: " + typ);
                return new Krankenschwester(name, skill, erfahrung, krankenschwesterBerufe[random.nextInt(krankenschwesterBerufe.length)], datum);
            default:
                // Sollte nie auftreten, da typ nur 0,1 oder 2 sein kann
                throw new IllegalStateException("Unbekannter Typ: " + typ);
        }
    }
}
