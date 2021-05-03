package com.techelevator;

import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductDispenserTest {

    @Test
    public void testing_date_time_format (){


        // testing to see that the format is yyyy-MM-dd hh:mm:ss a

        ProductDispenser dispenser = new ProductDispenser();

        String returnedDate = dispenser.getFormattedDate();

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

        ProductDispenser dispenser = new ProductDispenser();
        Funds funds = new Funds();
        Drink sprite = new Drink("sprite", new BigDecimal(2), "A2");

        dispenser.logMaker(funds, sprite);

        File testingFile = new File("log.txt");

        boolean doesTheFileExist = testingFile.exists();

        boolean expectedDoesTheFileExist = true;

        assertEquals(doesTheFileExist, expectedDoesTheFileExist);

    }


}