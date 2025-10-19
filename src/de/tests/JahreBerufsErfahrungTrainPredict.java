package de.tests;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.datenbank.BewerberJsonDatenbankUndService;
import de.backend.machinelearning.HardCodedProbabilities;
import de.backend.machinelearning.MultipleLinearRegression;
import de.backend.machinelearning.SimpleLinearRegression;


import java.util.List;

public class JahreBerufsErfahrungTrainPredict {
    public static void main(String[] args) {
        BewerberJsonDatenbankUndService db=new BewerberJsonDatenbankUndService();
        HardCodedProbabilities hardcodedprobs=new HardCodedProbabilities();
        db.laden();
        List<CharakterBewerberpool> bewerber= db.getAlleBewerber();


        double [] years=new double[bewerber.size()];
        double [] endnote=new double[bewerber.size()];
        for (int i = 0; i < bewerber.size() ; i++) {
            years[i]=bewerber.get(i).getJahreBerufserfahrung();
            endnote[i]=bewerber.get(i).getEndbewerbernoten();
            System.out.println("Array mit jahre erfahrung: "+ years[i]);

        }


        //SimpleLinearRegression linregressionmodel= new SimpleLinearRegression();
        MultipleLinearRegression multipleLinearRegression=new MultipleLinearRegression();

        //linregressionmodel.train(yearsofexpereinceX,probabilitiesofbeingselectedY);
        double [] probabilities=new double[bewerber.size()];
        for (int i = 0; i < bewerber.size(); i++) {
            probabilities[i]= hardcodedprobs.einstellungsWahrscheinlichkeit(bewerber.get(i).getJahreBerufserfahrung());
         //Randomprob not good idea as data should be similar to real data
/*          Random wuerfel=new Random();
            double probabilitiesY=wuerfel.nextDouble(0.1,100);*/
           ;
            System.out.println("testprob" + probabilities[i]);

        }

       /* linregressionmodel.train(years,probabilities);
        linregressionmodel.berechneMSE(years,probabilities);
        System.out.println(linregressionmodel.predict(2));*/

/*        multipleLinearRegression.train(years,endnote,probabilities);
        System.out.println(multipleLinearRegression.predict(5,100));*/


        //retrain für ein feature fürrt methode button retrain für X1 years dann kann man predict richtig ausführen
        multipleLinearRegression.train(years,endnote,probabilities);
        System.out.println(multipleLinearRegression.predict(10,100));
        //retrain für zwei feature fürrt methode button retrain für X1 years und X2 endnote dann kann man predict richtig ausführen

        multipleLinearRegression.train(years, probabilities);
        System.out.println(multipleLinearRegression.predict(8));
    }


}


//Just some tests:

/*double yearsofexperiencefirstapplicant= bewerber.getFirst().getJahreBerufserfahrung();
double yearsofexperiencelastapplicant= bewerber.getLast().getJahreBerufserfahrung();
double [] yearsofexpereinceX={yearsofexperiencelastapplicant,yearsofexperiencefirstapplicant};
//double [] probabilitiesofbeingselectedY={0.2,0.7};
double [] probabilitiesofbeingselectedY=new double[bewerber.size()];*/
