package org.exampledana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Biathlon biathlon=new Biathlon();
        String stringResults= "";
        try {
            BufferedReader br = new BufferedReader( new FileReader( "src/main/results.csv" ) );
            br.readLine();

            String string= "";
            while((string=br.readLine())!=null){
               stringResults+=string+"\n";
            }
            biathlon.addAthleteResultsFromFile(stringResults);
        } catch (IOException e) {
            System.out.println("CSV file not found!");
        }
        System.out.println(stringResults);
        try {
            biathlon.findAndPrintPodiumWinners();
        } catch (Exception e){
            System.out.println("Unable to print results. Please check CSV file!");
        }
    }
}
