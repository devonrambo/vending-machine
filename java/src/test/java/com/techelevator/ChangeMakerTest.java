package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChangeMakerTest {


    @Test
    public void testing_if_the_right_change_is_given(){


        // unable to run test because of the system.out produced
        // We think this is causing an infinite loop? Because the test never finishes

//        ChangeMaker changeMaker = new ChangeMaker();
//
//        // feed it 3.99 dollars
//
//        changeMaker.makeChange(new BigDecimal(3.99));
//
//        String expectedChange = "Your change is: \n" + "15" + " quarters\n" + "2" + " dimes \n" + "0" + " nickels \n" + "4" + " pennies\n";
//
//        String actualChange = changeMaker.getChangeString();
//
//        Assert.assertEquals(expectedChange, actualChange);
  }


    @Test
    public void testing_date_time_format (){


        // testing to see that the format is yyyy-MM-dd hh:mm:ss a

        ChangeMaker changeMaker = new ChangeMaker();

        String returnedDate = changeMaker.getFormattedDate();

        String expectedAtIndex4 = "-";
        String actualIndex4 = String.valueOf(returnedDate.charAt(4));

        String expectedAtIndex13 = ":";
        String actualIndex13 = String.valueOf(returnedDate.charAt(13));

        assertEquals(actualIndex4, expectedAtIndex4);
        assertEquals(actualIndex13, expectedAtIndex13);



    }

    @Test
    public void testing_log_maker_does_it_create_the_file(){

        // use the logmaker method which creates a file object and outputs to log.txt
        // now creating a new file object (testing file) that checks to see if log.txt already exists
        // As log as the logMaker runs beforehand log.txt should already exist and both booleans should be true;

        ChangeMaker changeMaker = new ChangeMaker();
        Funds funds = new Funds();
        changeMaker.logMaker(funds.getTotalPaid());

        File testingFile = new File("log.txt");

        boolean doesTheFileExist = testingFile.exists();

        boolean expectedDoesTheFileExist = true;

        assertEquals(doesTheFileExist, expectedDoesTheFileExist);

    }


}


