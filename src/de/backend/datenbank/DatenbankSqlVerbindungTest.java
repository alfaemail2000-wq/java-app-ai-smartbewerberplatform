package de.backend.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//wuerde in Projekt kaum ausgenuzt gehört dazu und für Übungszweck während Projektphase vorbeireitet falls man weiter an SQL danbank nutzt

public class DatenbankSqlVerbindungTest {

    public static void main(String[] args) throws SQLException {

        String url="jdbc:mysql://localhost:3306/bewerber_db?createDatabaseIfNotExist=true";
        String user="root";
        String passwort="";

        Connection verbindung= DriverManager.getConnection(url,user,passwort);


    }
}
