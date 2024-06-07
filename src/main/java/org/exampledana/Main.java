package org.exampledana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biathlon biathlon=new Biathlon();
        try {
            Scanner scan= new Scanner(new File("src/main/results.csv"));
             scan.nextLine();

            while(scan.hasNextLine()){
                String string= scan.nextLine();
                biathlon.addAthleteResultsFromFile(string);
            }
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found!");
        }
        biathlon.findAndPrintPodiumWinners();


        //System.out.println(biathlon);
//        Athlete john= new Athlete("2","John Doe", "UK", "30:10", "xxoxo","xoxox","oxxox");
//        System.out.println(john);
//        biathlonResults.add(john);
//        biathlon.addNewAthlete("1","Ion Popa", "RO", "30:27", "xxoxx","xxoxx","oxxxx");
    }

}
