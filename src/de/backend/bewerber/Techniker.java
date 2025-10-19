package de.backend.bewerber;

//Noch nicht vollstaendig implementiert


import java.time.LocalDate;

public class Techniker extends CharakterBewerberpool implements NichtAkademischeStudiumAbsolvent
{
    public Techniker(String name, String skill, int jahreBerufserfahrung, String beruf, LocalDate abschlussdatum) {
        super(name, skill, jahreBerufserfahrung, beruf, abschlussdatum);
    }

    @Override
    public void praktischArbeiten() {
        System.out.println("ich kann praktisch Arbeiten und geräte bedienen oder einem Ingenier helfen");

    }
}
