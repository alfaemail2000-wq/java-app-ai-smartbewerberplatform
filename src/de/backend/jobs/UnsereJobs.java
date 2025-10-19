package de.backend.jobs;

/**
 * Klasse, die statisch definierte Job-Objekte bereitstellt.
 *
 * Dient als einfache, festgelegte Sammlung von Jobs mit ihren Eigenschaften,
 * die im Programm überall genutzt werden können.
 */
public class UnsereJobs {

    // Statisch definierte Job-Objekte mit Berufserfahrung, Abschlussart, Gehalt und Jobbezeichnung

    public static final Job ARZTHAUS = new Job(5, true, 50000, "Artzt");
    public static final Job INGENIERMASCHINEBAU = new Job(2, true, 60000, "Ingenieur");
    public static final Job TECHNIKERZEICHNER = new Job(5, false, 42000, "Techniker");
    public static final Job KRANKENSCHWESTERAMBULANT = new Job(3, false, 38000, "Krankenschwester");

    /**
     * Privater Konstruktor, um zu verhindern, dass Objekte von dieser Klasse erstellt werden.
     * UnsereJobs dient nur zur Bereitstellung der statischen Job-Instanzen.
     */
    private UnsereJobs() {
        // keine Instanzierung erwünscht
    }

    /**
     * Gibt alle Jobs in einer definierten Reihenfolge als Array zurück.
     *
     * @return Array mit allen Job-Objekten in der Reihenfolge: Arzt, Ingenieur, Techniker, Krankenschwester
     */
    public static Job[] jobsInReihenfolge() {
        Job[] dieJobs = {ARZTHAUS, INGENIERMASCHINEBAU, TECHNIKERZEICHNER, KRANKENSCHWESTERAMBULANT};
        return dieJobs;
    }
}
