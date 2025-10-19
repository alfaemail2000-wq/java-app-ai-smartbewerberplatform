package de.backend.datenbank;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.backend.bewerber.CharakterBewerberpool;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import de.backend.jobs.Job;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviceklasse zur Verwaltung von Bewerbern in einer JSON-Datenbank.
 *
 * Diese Klasse bietet Funktionen zum Hinzufügen, Speichern, Laden,
 * Finden und Löschen von Bewerbern in einer JSON-Datei.
 *
 * Wichtig:
 * - Verwendet Jackson für JSON Serialisierung und Deserialisierung.
 * - Unterstützt polymorphe Typen mit aktivierter Typinformation.
 * - Verwaltet intern eine Liste von Bewerbern (CharakterBewerberpool).
 */
public class BewerberJsonDatenbankUndService {

    // Interne Liste, die alle Bewerberobjekte hält
    private List<CharakterBewerberpool> bewerberListe = new ArrayList<>();

    // Pfad zur JSON-Datei, in der Bewerberdaten gespeichert werden
    private static final String DATEI_PFAD = "bewerber.json";

    // ObjectMapper von Jackson zum JSON (De-)Serialisieren
    private final ObjectMapper mapper;

    // Zähler für die nächste Bewerber-ID, um eindeutige IDs zu vergeben
    int naechsteId;

    /**
     * Konstruktor initialisiert den ObjectMapper mit JavaTimeModule für
     * korrekte Handhabung von LocalDate und aktiviert polymorphe Typinformationen,
     * damit verschiedene Bewerber-Klassen korrekt gespeichert und geladen werden.
     */
    public BewerberJsonDatenbankUndService() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        // Aktiviert polymorphe Typinformationen für alle nicht-finalen Klassen,
        // um korrekte Serialisierung/Deserialisierung von Unterklassen zu ermöglichen.
        mapper.activateDefaultTyping(
                mapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );

        /*
           Die folgende alternative Aktivierungsmethode ist auskommentiert,
           weil hier eine andere Typ-Strategie gewählt wurde.
           Sie könnte verwendet werden, um Typinformationen für abstrakte Klassen
           und Arrays zu aktivieren.

        mapper.activateDefaultTyping(
                mapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS,
                JsonTypeInfo.As.PROPERTY
        );
        */
    }

    /**
     * Fügt einen neuen Bewerber zur internen Liste hinzu und weist eine eindeutige ID zu.
     * @param bewerber der hinzuzufügende Bewerber
     */
    public void bewerberHinzufuegen(CharakterBewerberpool bewerber) {
        // Setzt dem Bewerber automatisch eine eindeutige ID
        bewerber.setBewerberId(naechsteId);
        naechsteId++;
        bewerberListe.add(bewerber);
    }

    /**
     * Gibt die komplette Liste aller Bewerber zurück.
     * @return Liste aller Bewerberobjekte
     */
    public List<CharakterBewerberpool> getAlleBewerber() {
        return bewerberListe;
    }

    /**
     * Speichert die interne Bewerberliste als JSON-Datei am definierten Pfad.
     * Gibt eine Erfolgsmeldung auf der Konsole aus oder Fehler bei Problemen.
     */
    public void speichern() {
        try {
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(new File(DATEI_PFAD), bewerberListe);
            System.out.println("✅ Bewerber gespeichert nach JSON");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt Bewerberdaten aus der JSON-Datei in die interne Liste.
     * Aktualisiert auch die naechsteId, um ID-Konflikte zu vermeiden.
     * Gibt Statusmeldungen auf der Konsole aus.
     */
    public void laden() {
        try {
            File file = new File(DATEI_PFAD);
            if (file.exists()) {
                bewerberListe = mapper.readValue(file, new TypeReference<List<CharakterBewerberpool>>() {});
                System.out.println("✅ Bewerber aus JSON geladen");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Bestimme die höchste vorhandene Bewerber-ID, damit neue IDs fortlaufend sind
        int maxId = 0;
        for (CharakterBewerberpool bewerber : bewerberListe) {
            if (bewerber.getBewerberId() > maxId) {
                maxId = bewerber.getBewerberId();
            }
        }
        naechsteId = maxId + 1;
    }

    /**
     * Prüft anhand eines einzelnen Bewerbers und eines Jobs, ob der Bewerber
     * passend für den Job ist (Klassenname enthält Jobname & Berufserfahrung passt).
     * Gibt für jeden Bewerber eine passende oder nicht passende Meldung aus.
     * @param einzelnerBewerber einzelner Bewerber (nicht verwendet in Methode)
     * @param job Job, auf den sich die Passung bezieht
     */
    public void findePassendeBewerber(CharakterBewerberpool einzelnerBewerber, Job job) {
        List<CharakterBewerberpool> bewerberListe = getAlleBewerber();

        for (CharakterBewerberpool b : bewerberListe) {
            String bewerberKlasse = b.getClass().getSimpleName().toLowerCase(); // z. B. "artzt"
            String jobName = job.getName().toLowerCase();                      // z. B. "arztz"

            if (bewerberKlasse.contains(jobName) && b.getJahreBerufserfahrung() >= job.getJahreBerufserfahrung()) {
                System.out.println("✅ PASSEND: " + b.getClass().getSimpleName() + " mit Erfahrung: " + b.getJahreBerufserfahrung());
            } else {
                System.out.println("❌ NICHT passend: " + b.getClass().getSimpleName() + " (" + b.getJahreBerufserfahrung() + " Jahre)");
            }
        }
    }

    /**
     * Gibt eine Liste mit passenden Bewerbern zurück, die den Jobanforderungen entsprechen.
     * Filterkriterien: Klassenname des Bewerbers enthält Jobname, und Berufserfahrung passt.
     * @param job Job, für den passende Bewerber gesucht werden
     * @return Liste der passenden Bewerber
     */
    public List<CharakterBewerberpool> findePassendeBewerberListe(Job job) {
        List<CharakterBewerberpool> bewerberListe = getAlleBewerber();

        return bewerberListe.stream()
                .filter(b -> {
                    String bewerberKlasse = b.getClass().getSimpleName().toLowerCase();
                    String jobName = job.getName().toLowerCase();

                    // Bewerber passt, wenn Klassenname Jobnamen enthält und Berufserfahrung ausreicht
                    return bewerberKlasse.contains(jobName) && b.getJahreBerufserfahrung() >= job.getJahreBerufserfahrung();
                })
                .collect(Collectors.toList());
    }

    /**
     * Löscht einen Bewerber anhand seiner eindeutigen Bewerber-ID aus der Liste.
     * @param id ID des zu löschenden Bewerbers
     */
    public void loescheBewerberNachId(int id) {
        this.bewerberListe.removeIf(b -> b.getBewerberId() == id);
    }
}
