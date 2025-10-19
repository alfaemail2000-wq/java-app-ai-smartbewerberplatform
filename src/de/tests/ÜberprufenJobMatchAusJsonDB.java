package de.tests;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.datenbank.BewerberJsonDatenbankUndService;
import de.backend.datenbank.JsonBewerberNotExist;
import de.backend.jobs.Job;
import de.backend.jobs.Jobs;
import de.backend.jobs.UnsereJobs;

import java.util.List;
import java.util.Random;

//Überprufft ob der ausgewählte bzw generierte Randome Bewerber passt zur Job, der ueberpruffung wird stattfinden in der
//db.findePassendeBewerber(randombewerber,jobausenum3) es filtert nach Job("name") und Job("berufserfahrung") welche Json bewerber passt zur Job aus ENUM

public class ÜberprufenJobMatchAusJsonDB {

    public static void main(String[] args) {

        BewerberJsonDatenbankUndService db = new BewerberJsonDatenbankUndService();
        db.laden();
        List<CharakterBewerberpool> allsuccessfulljsonbewerber= db.getAlleBewerber();

        Random wuerfelbewerber=new Random();
        int randombewerberIndex=wuerfelbewerber.nextInt(allsuccessfulljsonbewerber.size());//eventuel per eingabe in Terminal


        CharakterBewerberpool randombewerber=allsuccessfulljsonbewerber.get(randombewerberIndex);


        try {

            System.out.println("Successful random bewerber test"+randombewerber);
            }
        catch (IndexOutOfBoundsException e){
            throw new JsonBewerberNotExist("This Applicant does not exist in JSON file with Index: ["+randombewerberIndex);


        };
        /*List<CharakterBewerberpool> all=allsuccessfulljsonbewerber.get(randombewerberIndex);*/

        //JobList

        Job jobausenum1= UnsereJobs.ARZTHAUS;
        Job jobausenum2= UnsereJobs.INGENIERMASCHINEBAU;
        Job jobausenum3= UnsereJobs.TECHNIKERZEICHNER;

        Random wuerfeljob= new Random();

        int JobIndex=wuerfeljob.nextInt(Jobs.values().length);
        Jobs derJob=Jobs.values()[JobIndex];

        System.out.println("this is a index in Array Jobs: "+derJob.ordinal()+"--Job name--" +derJob);

        switch (derJob){
            case ARZTHAUS:
                Jobs job1=Jobs.valueOf(String.valueOf(derJob));
                System.out.println("Gehalt: "+job1.berechneMonatsGehalt());
                System.out.println("hier überpruft alle Arzte aus JSON datenbank ob passt\n");
                System.out.println("derjob -"+derJob);
                System.out.println("sucessfulbewerber- "+randombewerber);
                db.findePassendeBewerber(randombewerber,jobausenum1);
                break;
            case INGENIERMASCHINEBAU:
                Jobs job2=Jobs.valueOf(String.valueOf(derJob));
                System.out.println("Gehalt: "+job2.berechneMonatsGehalt());
                System.out.println("hier überpruft alle Ingenieure aus JSON datenbank ob passt");
                System.out.println("sucessfulbewerber- "+allsuccessfulljsonbewerber);
                db.findePassendeBewerber(randombewerber,jobausenum2);
                break;
            case TECHNIKERZEICHNER:
                Jobs job3=Jobs.valueOf(String.valueOf(derJob));
                System.out.println("Gehalt: "+job3.berechneMonatsGehalt());
                System.out.println("hier überpruft alle TechnischeZeichner aus JSON datenbank ob passt");
                System.out.println("sucessfulbewerber- "+allsuccessfulljsonbewerber);
                db.findePassendeBewerber(randombewerber,jobausenum3);
                break;
            case KRANKENSCHWESTERAMBULANT:
                Jobs job4=Jobs.valueOf(String.valueOf(derJob));
                System.out.println("Gehalt: "+job4.berechneMonatsGehalt());
                System.out.println("hier überpruft alle Krankenschwestern aus JSON datenbank ob passt");
                break;




        }


}}
