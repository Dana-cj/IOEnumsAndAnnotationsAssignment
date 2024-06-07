package org.exampledana;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Biathlon implements Serializable {
    //private static final long serialVersionUID = 1l;
    private Set<Athlete> biathlonResults;
    public Biathlon(){
        this.biathlonResults=new TreeSet<>();
    }

    Set<Athlete> getBiathlonResults() {
        return biathlonResults;
    }

    public void addNewAthlete(String athleteNumber, String name, String countryCode, String stringSkiTimeResult, String firstShooting, String secondShooting, String thirdShooting){
        biathlonResults.add(new Athlete(athleteNumber, name, countryCode, stringSkiTimeResult, firstShooting, secondShooting, thirdShooting));
    }

   public void addAthleteResultsFromFile(String string) {
        String[] athlete= string.split(",");
        String athleteNumber= athlete[0].trim();
        String name=athlete[1].trim();
        String countryCode= athlete[2].toUpperCase().trim();
        String skiTimeResult= athlete[3].trim();
        String firstShooting= athlete[4].trim();
        String secondShooting= athlete[5].trim();
        String thirdShooting = athlete[6].trim();
        addNewAthlete(athleteNumber,name,countryCode,skiTimeResult,firstShooting,secondShooting,thirdShooting);
    }
    public void findAndPrintPodiumWinners(){
        Set<Athlete> winners= new TreeSet<>(biathlonResults);
        System.out.println("RESULTS:");
        String[] places={"Winner- ","Runner-up- ", "Third Place- "};
        for(int i=0; i<=2; i++){
            System.out.print(places[i]);
            Athlete athletePodium= ((TreeSet<Athlete>)winners).pollFirst();
            System.out.println(athletePodium.getName()+" "+athletePodium.getFinalStanding()+" ("+athletePodium.getSkiTimeResult()+" + "+athletePodium.getPenalty()+")");
        }
    }

    @Override
    public String toString() {
        return "Biathlon{" +
                "biathlonResults=" + biathlonResults +
                '}';
    }
}
