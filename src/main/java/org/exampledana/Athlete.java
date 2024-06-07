package org.exampledana;

import java.io.Serializable;
import java.time.Duration;
import java.util.Objects;

public class Athlete implements Serializable, Comparable<Athlete>{
    private int athleteNumber;
    private String name;
    private CountryCode countryCode;
    private Duration skiTimeResult;//in seconds
    private Duration finalStanding;//in seconds
    private String firstShooting;
    private String secondShooting;
    private String thirdShooting;
    public Athlete(){
     }
    public Athlete(String athleteNumber, String name, String countryCode, String skiTimeResult, String firstShooting, String secondShooting, String thirdShooting) {
        this.athleteNumber= Integer.parseInt(athleteNumber);
        this.name = name;
        this.countryCode = CountryCode.valueOf(countryCode);
        this.skiTimeResult = setSkiTimeResult(skiTimeResult);
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
        this.finalStanding = setFinalStanding();
    }

    public String getName() {
        return name;
    }

    public String getFinalStanding() {
        return (""+finalStanding).replace("PT","").replace("M",":").replace("S","");
    }

    public String getSkiTimeResult() {
        return convertDuration(skiTimeResult);
    }

    public String getPenalty(){
        return convertDuration(calculatePenalty());
    }

public static String convertDuration(Duration duration){
        long min= duration.getSeconds()/60;
        String minStr=""+min;
        if(minStr.length()<2){
            minStr="0"+minStr;
        }
        long sec= duration.getSeconds()%60;
        String secStr= ""+sec;
        if(secStr.length()<2){
            secStr="0"+secStr;
        }
        return minStr+":"+secStr;
}

    Duration setSkiTimeResult(String skiTimeResult){
        String[] skiTimeResultArray= skiTimeResult.split(":");
        int time=Integer.parseInt(skiTimeResultArray[0])*60+Integer.parseInt(skiTimeResultArray[1]);
        return Duration.ofSeconds(time);
    }
     Duration calculatePenalty(){
        String shooting= firstShooting+secondShooting+thirdShooting;
        int missedShots=0;
        for (String shot:shooting.split("")) {
            if(shot.equals("o")){
                missedShots++;
            };
        }
        Duration penalty= Duration.ofSeconds(missedShots*10);
        return penalty;
    }

    protected Duration setFinalStanding(){
       Duration finalTime= skiTimeResult.plus(calculatePenalty());
       return finalTime;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athlete number=" + athleteNumber +
                ", name='" + name + '\'' +
                ", countryCode=" + countryCode +
                ", skiTimeResult=" + skiTimeResult +
                ", firstShooting='" + firstShooting + '\'' +
                ", secondShooting='" + secondShooting + '\'' +
                ", thirdShooting='" + thirdShooting + '\'' +
                ", finalTimeResult=" + finalStanding +
                '}';
    }
    @Override
    public int compareTo(Athlete o) {
        return this.finalStanding.compareTo(o.finalStanding);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete athlete = (Athlete) o;
        return athleteNumber == athlete.athleteNumber && Objects.equals(name, athlete.name) && countryCode == athlete.countryCode && Objects.equals(skiTimeResult, athlete.skiTimeResult) && Objects.equals(finalStanding, athlete.finalStanding) && Objects.equals(firstShooting, athlete.firstShooting) && Objects.equals(secondShooting, athlete.secondShooting) && Objects.equals(thirdShooting, athlete.thirdShooting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(athleteNumber, name, countryCode, skiTimeResult, finalStanding, firstShooting, secondShooting, thirdShooting);
    }
}
