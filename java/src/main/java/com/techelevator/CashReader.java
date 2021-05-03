package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CashReader {

    public void handleFeedMoney(Menu menu, String[] MONEY_OPTIONS, Funds funds) {

        boolean stay = true;
        while (stay) {

            String choice = (String) menu.getChoiceFromOptions(MONEY_OPTIONS);

            if (choice.equals("$1")) {
                funds.addMoney(new BigDecimal(1));
                logMaker(funds);

            } else if (choice.equals("$2")) {
                funds.addMoney(new BigDecimal(2));
                logMaker(funds);
            } else if (choice.equals("$5")) {
                funds.addMoney(new BigDecimal(5));
                logMaker(funds);
            } else if (choice.equals("$10")) {
                funds.addMoney(new BigDecimal(10));
                logMaker(funds);
            } else if (choice.equals("Back")) {
                stay = false;
            }
            System.out.println("Current Money Proved: $" + funds.getTotalPaid());


        }

    }

    public void logMaker(Funds funds){

        try {
            File outputFile = new File("log.txt");
            outputFile.createNewFile();
            FileOutputStream output = new FileOutputStream(outputFile, true);
            PrintWriter writer = new PrintWriter(output);

            String dateExperiment = getFormattedDate();


            String lineToReturn = dateExperiment + " | FEED MONEY | $" + funds.getTotalPaid().subtract(funds.getMoneyBeforeAction()) + " | $" + funds.getTotalPaid() + "\n";

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
