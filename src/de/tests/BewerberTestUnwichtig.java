package de.tests;

import de.backend.bewerber.Artzt;
import de.backend.bewerber.CharakterBewerberpool;
import de.backend.bewerber.Ingenieur;
import de.backend.bewerber.Interviewer;
import de.backend.service.BewerbungsgesprächTournier;

import java.time.LocalDate;

//Weitere tests an Bewerber

public class BewerberTestUnwichtig {

    public static void main(String[] args) {
        CharakterBewerberpool artzt1= new CharakterBewerberpool("jon","CAD", 0,"sdf", LocalDate.now());
        Artzt artzt=new Artzt("jonnnn","bigD", 5,"sdf", LocalDate.now());
        System.out.println("jare erfahrung:: " + artzt1.getJahreBerufserfahrung());
        System.out.println("Anzahl von behandelte patienten!! " + artzt.behandeltepatientenbehandeltAllgeein());


        CharakterBewerberpool ingrnirt1= new CharakterBewerberpool("jon","CAD", 0,"sdf", LocalDate.now());
        Ingenieur ingenieur=new Ingenieur("jonnnn","bigD", 6,"sdf", LocalDate.now());


        System.out.println("jare erfahrung:: " + ingenieur.getJahreBerufserfahrung());
        System.out.println("Anzahl von behandelte patienten!! " + ingenieur.behandeltepProjektenAllgeein());


        System.out.println("SEPARATOR: ********************************************: SEPARATOR");


        Artzt artz1= new Artzt();
        Ingenieur ingenieur1= new Ingenieur();
        Interviewer interviewer= new Interviewer("John","bewerbertesten",10,"HR", LocalDate.now());

        interviewer.getBewerbernote();
        interviewer.getExtrapunkte();

        interviewer.bewerberBewerten(artz1);
        interviewer.bewerberBewerten(ingenieur1);


        //CharakterBewerberpool [] bewerberarray={artz1,ingenieur1};

        System.out.println("Arzt status" + artz1.erstellenStatusinformation());
        System.out.println(
                "*******************----Statusseparator----*****************"
        );
        System.out.println("Ingenier status" +ingenieur1.erstellenStatusinformation());



        BewerbungsgesprächTournier bg=new BewerbungsgesprächTournier();
        bg.bewerbungsrunde(artz1);
        bg.bewerbungsrunde(ingenieur1);
    }
}
