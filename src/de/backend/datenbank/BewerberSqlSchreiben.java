package de.backend.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//wuerde in Projekt kaum ausgenuzt gehört dazu und für Übungszweck während Projektphase vorbeireitet falls man weiter SQL danbank nutzt


public class BewerberSqlSchreiben {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/bewerber_db?createDatabaseIfNotExist=true";
        String user="root";
        String passwort="";

        Connection verbindung= DriverManager.getConnection(url,user,passwort);
        Statement umwandler=verbindung.createStatement();
        String sqleinGabe="INSERT INTO Bewerberprofile VALUES(NULL, 'Anjelina', 'Krankeschw',60,'Medikament geben', '2025-1-19')";
        umwandler.execute(sqleinGabe);
        System.out.println("Erfolgreich geschriebe");
    }
}
