package com.techelevator;

import com.techelevator.view.Menu;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class CashReaderTest {


    @Test
    public void testing_date_time_format (){


        // testing to see that the format is yyyy-MM-dd hh:mm:ss a

        CashReader cashReader = new CashReader();

        String returnedDate = cashReader.getFormattedDate();

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

        CashReader cashReader = new CashReader();
        Funds funds = new Funds();
        cashReader.logMaker(funds);

        File testingFile = new File("log.txt");

        boolean doesTheFileExist = testingFile.exists();

        boolean expectedDoesTheFileExist = true;

        assertEquals(doesTheFileExist, expectedDoesTheFileExist);

    }

    // per the instructions the menu class does not need to be tested
    // no test for the handle_money_feed because it is too tightly coupled with the menu class
    // Is there a way to deal with system outs in tests? - something to research at a later date


}