package de.tests;

import de.backend.jobs.Job;
import de.backend.jobs.Jobs;
import de.backend.jobs.UnsereJobs;

public class EnumJobBeobachtTestUnwichtig {

    public static void main(String[] args) {
       Job[] allejobs=UnsereJobs.jobsInReihenfolge();

        for (int i = 0; i < allejobs.length; i++) {
            System.out.println("TestJobArrayausEnum:"+allejobs[i]);

        }

        System.out.println(allejobs[2]);

        Job Arzt1=UnsereJobs.ARZTHAUS;
        System.out.println("jobjahresberuferfahrung:"+Arzt1.getJahreBerufserfahrung());

        Jobs [] alljobs=Jobs.values();
        for(Jobs job:alljobs){
            System.out.println("each job: "+job);
        }
        int index1stjobArzt=Jobs.ARZTHAUS.ordinal();
        System.out.println("index of 1st job in enum with ordinal :"+index1stjobArzt);

        Jobs wunschjob=Jobs.valueOf("ARZTHAUS");
        System.out.println(wunschjob.name());


        System.out.println();






    }
}
