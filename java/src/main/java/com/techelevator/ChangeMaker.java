package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChangeMaker {

    private String changeString = null;

    public String getChangeString() {
        return changeString;
    }

    public void makeChange(BigDecimal changeGiven){
        BigDecimal change = changeGiven;

        int numOfQuarters = 0;
        int numOfDimes = 0;
        int numOfNickels = 0;
        int numOfPennies = 0;
        BigDecimal quarterValue = new BigDecimal(25);
        BigDecimal dimeValue = new BigDecimal(10);
        BigDecimal nickelValue = new BigDecimal(5);
        BigDecimal pennyValue = new BigDecimal(1);

        BigDecimal changeCents = change.multiply(new BigDecimal(100));

        boolean keepItRunning = true;

        while(keepItRunning){

            if(changeCents.compareTo(quarterValue) >= 0){
                numOfQuarters++;
                changeCents = changeCents.subtract(quarterValue);
            }
            else if(changeCents.compareTo(dimeValue) >= 0){
                numOfDimes++;
                changeCents = changeCents.subtract(dimeValue);
            }
            else if(changeCents.compareTo(nickelValue) >= 0){
                numOfNickels++;
                changeCents =  changeCents.subtract(nickelValue);
            }
            else if(changeCents.compareTo(pennyValue) >= 0){
                numOfPennies++;
                changeCents = changeCents.subtract(pennyValue);
            }

            if(changeCents.compareTo(new BigDecimal(0)) == 0)
            {
                keepItRunning = false;
            }

        }

        logMaker(change);

        changeString = "Your change is: \n" + numOfQuarters + " quarters\n" + numOfDimes + " dimes \n" + numOfNickels + " nickels \n" + numOfPennies + " pennies\n";

        System.out.println(changeString);




    }

    public void logMaker(BigDecimal change){
        try {
            File outputFile = new File("log.txt");
            outputFile.createNewFile();
            FileOutputStream output = new FileOutputStream(outputFile, true);
            PrintWriter writer = new PrintWriter(output);


         String dateExperiment = getFormattedDate();


            BigDecimal beforePurchaseFunds = new BigDecimal(0);


            String lineToReturn = dateExperiment + " | GIVE CHANGE: $" + change + " | $0.00 \n";

            writer.append(lineToReturn);
            writer.flush();
            writer.close();

        } catch (Exception e) {

        }


    }

    public String getFormattedDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        String properDateFormat = LocalDateTime.now().format(formatter);
        return properDateFormat;

    }
}
