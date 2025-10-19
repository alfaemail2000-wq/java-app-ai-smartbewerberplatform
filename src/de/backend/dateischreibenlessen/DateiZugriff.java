package de.backend.dateischreibenlessen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;


//wuerde in Projekt kaum ausgenuzt gehört dazu und für Übungszweck während Projektphase vorbeireitet falls man weiter an SQL danbank nutzt

public class DateiZugriff {




    public void besserSchreiben(File ziel, String text){


        try(Writer schreiber=new FileWriter(ziel,true);
            BufferedWriter besserschreiber=new BufferedWriter(schreiber);){
            besserschreiber.newLine();
            besserschreiber.write(text);


        }catch (Exception schreibeausnahmeIO){
            schreibeausnahmeIO.printStackTrace();
        }
    }
}
