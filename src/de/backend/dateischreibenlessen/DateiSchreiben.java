package de.backend.dateischreibenlessen;

import java.io.File;


//Schreibe ein file mit Bewerbernotten bzw. Erfolgsbewerber


public class DateiSchreiben {


    public String erfolreicheBewerberSchreiben (String bewerber){

        String erfolgsBewerber=bewerber;
        DateiZugriff textdateischreiber=new DateiZugriff();


        File filebewerber=new File("Bewerbertextfiles/Erfolgreichebewerberfiles.txt");
        //filebewerber.mkdir();

        textdateischreiber.besserSchreiben(filebewerber,erfolgsBewerber);

        return erfolgsBewerber;
    }}



    //String erfolgsBewerber=artzt.erstellenStatusinformation();





