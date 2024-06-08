package org.exampledana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Biathlon biathlon=new Biathlon();
        try {
            BufferedReader br = new BufferedReader( new FileReader( "src/main/results.csv" ) );
            br.readLine();
//            Scanner scan= new Scanner(new File("src/main/results.csv"));
//             scan.nextLine();
            String string= "";
            while((string=br.readLine())!=null){
               //string= scan.readLine();
               biathlon.addAthleteResultsFromFile(string);
            }
           // System.out.println(biathlon);
        } catch (IOException e) {
            System.out.println("CSV file not found!");
        }
        try {
            biathlon.findAndPrintPodiumWinners();
        } catch (Exception e){
            System.out.println("Unable to print results. Please check CSV file!");
        }

//        System.out.println(biathlon);
//        Athlete john= new Athlete("2","John Doe", "UK", "30:10", "xxoxo","xoxox","oxxox");
//        System.out.println(john);
//        biathlonResults.add(john);
//        biathlon.addNewAthlete("1","Ion Popa", "RO", "30:27", "xxoxx","xxoxx","oxxxx");
    }
}
