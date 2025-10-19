package de.tests;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.datenbank.DatenBankSqlZugriff;
import de.backend.service.BewerberSqlService;
//SCHREIB AUCH LOGIN PAGE MIT UHRZEIT GESCHREIBNEN WENN USER LOGT UND PASSWOR DPBERPRUFE
import java.time.LocalDate;

public class SqlDatenbankTest {
    public static void main(String[] args) {

       BewerberSqlService ourservice;

       ourservice=new BewerberSqlService();

        System.out.println("Start");

        CharakterBewerberpool onebewerber=new CharakterBewerberpool("Test","GITARE",4,"sdf", LocalDate.now());

        System.out.println(onebewerber.getBewerberId());

        ourservice.getAllesBewerber().forEach(item-> System.out.println("This is our Applicant" + item));

        DatenBankSqlZugriff james= new DatenBankSqlZugriff();
        System.out.println("aktuele id: " + onebewerber.getBewerberId());


        james.schreibDerBewerber(onebewerber);

        System.out.println("aktuele id: " + onebewerber.getBewerberId());

        System.out.println("End");



    }
}
