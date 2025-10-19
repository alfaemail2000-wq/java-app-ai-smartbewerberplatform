package de.backend.datenbank;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.bewerber.PrimarschlusselException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//wuerde in Projekt kaum ausgenuzt gehört dazu und für Übungszweck während Projektphase vorbeireitet falls man weiter an SQL danbank nutzt


public class DatenBankSqlZugriff {

    private String url="jdbc:mysql://localhost:3306/bewerber_db?createDatabaseIfNotExist=true";
    private String user="root";
    private String passwort="";

    public List<CharakterBewerberpool> lesserDerBewerber()
    {
        List<CharakterBewerberpool> bewerberList=new ArrayList<>();

        String abfrage="SELECT*FROM Bewerberprofile";


        try(Connection verbindung= DriverManager.getConnection(url,user,passwort);
            Statement umwandler=verbindung.createStatement();
            ResultSet bewerberCursor=umwandler.executeQuery(abfrage)){

            while(bewerberCursor.next()){
                int bewerber_ID=bewerberCursor.getInt(1);
                String name=bewerberCursor.getString("name");
                String beruf=bewerberCursor.getString("beruf");
                int jareErfahrung=bewerberCursor.getInt("jahreerfahrung");
                String skill=bewerberCursor.getString("skill");
                LocalDate abschlussdatum= bewerberCursor.getDate("abschlussdatum").toLocalDate();
                CharakterBewerberpool ausDatenbank=new CharakterBewerberpool(name,skill,jareErfahrung,beruf,abschlussdatum);
                bewerberList.add(ausDatenbank);
            }

        }catch(SQLException e){e.printStackTrace();}




        return bewerberList;
    }

    public List<CharakterBewerberpool> schreibDerBewerber(CharakterBewerberpool zuSchreiben){

        if(zuSchreiben.getBewerberId()!=0){
            throw new PrimarschlusselException(("kien zweites id"));

        }
        String sqlcomando="INSERT INTO Bewerberprofile VALUES (NULL,?,?,?,?,?)";
        try (Connection verbindung = DriverManager.getConnection(url,user,passwort);
        PreparedStatement besserUmwandler=verbindung.prepareStatement(sqlcomando, Statement.RETURN_GENERATED_KEYS)
        ){
            besserUmwandler.setString(1,zuSchreiben.getName());
            besserUmwandler.setString(2, zuSchreiben.getBeruf());
            besserUmwandler.setInt(3,zuSchreiben.getJahreBerufserfahrung());
            besserUmwandler.setString(4, zuSchreiben.getSkill());
            besserUmwandler.setDate(5,Date.valueOf(zuSchreiben.getAbschlussdatum()));

                besserUmwandler.execute();
                ResultSet antwortMitSchlusessel = besserUmwandler.getGeneratedKeys();
               System.out.println("AntwortResultSet: "+antwortMitSchlusessel);
                antwortMitSchlusessel.next();
                int erzeugteId=antwortMitSchlusessel.getInt(1);
                zuSchreiben.setBewerberId(erzeugteId);

        }catch (SQLException schreibAusnahme){schreibAusnahme.printStackTrace();}


        return List.of();
    }




    }
