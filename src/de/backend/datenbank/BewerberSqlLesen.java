package de.backend.datenbank;

import java.sql.*;
import java.time.LocalDate;

//wuerde in Projekt kaum ausgenuzt gehört dazu und für Übungszweck während Projektphase vorbeireitet falls man weiter SQL danbank nutzt


public class BewerberSqlLesen {
    public static void main(String[] args) throws SQLException {

        String url="jdbc:mysql://localhost:3306/bewerber_db?createDatabaseIfNotExist=true";
        String user="root";
        String passwort="";

        Connection verbindung= DriverManager.getConnection(url,user,passwort);
        Statement umwandler=verbindung.createStatement();
        System.out.println(" Test \n"+ umwandler);
        String abfrage="SELECT * FROM bewerberprofile";
        ResultSet bewerberCursor=umwandler.executeQuery(abfrage);
        System.out.println(bewerberCursor);

        while (bewerberCursor.next()){
            System.out.println("und wireder ein Datensazt");
            //int schluessel=marmeldadenCursor.getInt("marmelade_id");
            int bewerberid=bewerberCursor.getInt(1);
            String name=bewerberCursor.getString(2);
            String beruf=bewerberCursor.getString(3);
            int jahreerfahrung=bewerberCursor.getInt(4);
            String skill=bewerberCursor.getString(5);
            LocalDate abschlussdatum= bewerberCursor.getDate(6).toLocalDate();
            System.out.println("|"+bewerberid+"|"+name+"|"+beruf+"|"+name+"|"+jahreerfahrung+"|"+abschlussdatum);

        }

    }
}
