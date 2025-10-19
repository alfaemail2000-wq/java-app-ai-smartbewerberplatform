package de.tests;

import de.backend.bewerber.Artzt;
import de.backend.bewerber.CharakterBewerberpool;
import de.backend.bewerber.Ingenieur;
import de.backend.bewerber.Krankenschwester;
import de.backend.datenbank.BewerberJsonDatenbankUndService;
import de.backend.service.BewerbungsgesprächTournier;


//Ein test um zu schauen das jeder Bewerber bekommt richtige methoden aus Interfaces und überschreibt elternklasse methoden

public class BewerberAusgabeJSON {
    public static void main(String[] args) {
        CharakterBewerberpool personeReference= new CharakterBewerberpool();
        BewerberJsonDatenbankUndService db = new BewerberJsonDatenbankUndService();
        db.laden();

        BewerbungsgesprächTournier interview= new BewerbungsgesprächTournier();

        //System.out.println("SEE BEWERBER"+ (db.getAlleBewerber()).get(5).getBewerberId());

        // Ausgabe + Casting
        for (CharakterBewerberpool persone : db.getAlleBewerber()) {

            if (persone instanceof Artzt) {
                Artzt a = (Artzt) persone;
                a.forschungBetreiben();
                a.praktischArbeiten();
                System.out.println("→ Ist ein Arzt mit Skill: " + a.getSkill());
                a.erstellenStatusinformation();

                System.out.println("Ist ein Arzt mit Bewerbernote: "+a.getName()+" "+a.getBewerbernote());
                System.out.println("Ist ein Arzt mit Extrapunkte: "+a.getName()+" "+a.getExtrapunkte());

            }

            if (persone instanceof Ingenieur) {
                Ingenieur i = (Ingenieur) persone;
                i.forschungBetreiben();

                System.out.println("→ Ist ein Ingenieur mit Skill: " + i.getSkill());
                i.erstellenStatusinformation();

                System.out.println("Ist ein Ingenieur Bewerbernote: "+i.getName()+" "+i.getBewerbernote());
                System.out.println("Ist ein Ingenieur Extrapunkte: "+i.getName()+" "+i.getExtrapunkte());

                if( persone instanceof Krankenschwester){
                    Krankenschwester k=(Krankenschwester) persone;
                    k.erstellenStatusinformation();
                    k.praktischArbeiten();
                    System.out.println("→ Ist ein Krankenschwester mit Skill: " + i.getSkill());
                    k.erstellenStatusinformation();
                }





            }


        }


    }

}


//Casting tests:

/*
Ingenieur testingenier=new AkademischeStudiumAbsolvent();
AkademischeStudiumAbsolvent einbewerber=(AkademischeStudiumAbsolvent)testingenier;
Ingenieur einingenier= new CharakterBewerberpool();
CharakterBewerberpool eincharakter=(CharakterBewerberpool) einingenier;

        System.out.println("Test----startt");
        einbewerber.forschungBetreiben();

        System.out.println("Test----end");*/
