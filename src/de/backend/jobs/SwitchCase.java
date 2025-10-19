package de.backend.jobs;

import java.util.Random;

//Testklasse für SwitchCase vorbereiten ist dann spater im tests ausgeliefert.

public class SwitchCase {

    public static void main(String[] args) {
        Random wuerfel=new Random();

        int JobIndex=wuerfel.nextInt(Jobs.values().length);
        Jobs derJob=Jobs.values()[JobIndex];

        System.out.println("this is a index in Array Jobs: "+derJob.ordinal()+"--Job name--" +derJob);

switch (derJob){
    case ARZTHAUS:
        Jobs job1=Jobs.valueOf(String.valueOf(derJob));
        System.out.println("Gehalt: "+job1.berechneMonatsGehalt());
        System.out.println("hier überpruft alle Arzte aus JSON datenbank ob passt");


        break;
    case INGENIERMASCHINEBAU:
        Jobs job2=Jobs.valueOf(String.valueOf(derJob));
        System.out.println("Gehalt: "+job2.berechneMonatsGehalt());
        System.out.println("hier überpruft alle Ingenieure aus JSON datenbank ob passt");
        break;
    case TECHNIKERZEICHNER:
        Jobs job3=Jobs.valueOf(String.valueOf(derJob));
        System.out.println("Gehalt: "+job3.berechneMonatsGehalt());
        System.out.println("hier überpruft alle TechnischeZeichner aus JSON datenbank ob passt");
        break;
    case KRANKENSCHWESTERAMBULANT:
        Jobs job4=Jobs.valueOf(String.valueOf(derJob));
        System.out.println("Gehalt: "+job4.berechneMonatsGehalt());
        System.out.println("hier überpruft alle Krankenschwestern aus JSON datenbank ob passt");
        break;


}


    }



}
