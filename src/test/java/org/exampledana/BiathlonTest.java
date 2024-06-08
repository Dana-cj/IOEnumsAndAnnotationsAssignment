package org.exampledana;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class BiathlonTest {
    @Test
  public void finalStatementWorks(){
        Assert.assertEquals("PT30M10S",""+(new Athlete("4","Franz Kafka", "CZ", "30:10", "xxxxx","xxxxx","xxxxx")).setFinalStanding());
        Assert.assertEquals("PT30M30S",""+(new Athlete("4","Franz Kafka", "CZ", "30:10", "xxoxx","xxxxx","xxoxx")).setFinalStanding());
        Assert.assertEquals("PT32M40S",""+(new Athlete("4","Franz Kafka", "CZ", "30:10", "ooooo","ooooo","ooooo")).setFinalStanding());
    }

    @Test

    public void parsingCsvFileWorks(){
        Biathlon biathlon1=new Biathlon(){};
        biathlon1.addNewAthlete("11","Umar Jorgson","SK","30:27","xxxox","xxxxx","xxoxo");
        biathlon1.addNewAthlete("1","Jimmy Smiles","UK","29:15","xxoox","xooxo","xxxxo");
        biathlon1.addNewAthlete("27","Piotr Smitzer","CZ","30:10","xxxxx","xxxxx","xxxxx");

        Biathlon biathlonTest= new Biathlon();
        biathlonTest.addAthleteResultsFromFile("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");
        biathlonTest.addAthleteResultsFromFile("1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo");
        biathlonTest.addAthleteResultsFromFile("27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx");

        Assert.assertEquals(biathlon1.getBiathlonResults(),biathlonTest.getBiathlonResults());
    }

    @ParameterizedTest
    @CsvSource(value = {"11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo"}, delimiter = '&')
    public void parametrizedParsingCsvFileWorks(String string){
       Athlete athleteTest= new Athlete("11","Umar Jorgson","SK","30:27","xxxox","xxxxx","xxoxo");
       Biathlon biathlonTest= new Biathlon();
       biathlonTest.addAthleteResultsFromFile(string);

        Assertions.assertTrue(biathlonTest.getBiathlonResults().contains(athleteTest));

    }
}
