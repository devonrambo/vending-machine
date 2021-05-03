package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ProductDispenser {

    public void handleProductSelection(List<VendableItem> inventory, Funds funds) {

        String[] arrSlot = new String[inventory.size()];

        for (int i = 0; i < inventory.size(); i++) {
            arrSlot[i] = inventory.get(i).getSlot();
            System.out.println(arrSlot[i]);
        }
        System.out.println("Please enter a slot option >>>");
        // String choice = (String) menu.getChoiceFromOptions(arrSlot);
        Scanner scanner = new Scanner(System.in);
        String slotChosen = scanner.nextLine();

        for (VendableItem item : inventory) {

            if (item.getSlot().equals(slotChosen)) {

                if (item.getAmountOf() <= 0) {
                    System.out.println("That item is sold out :( ");
                    break;
                }
                else if (funds.getTotalPaid().compareTo(item.getCost()) == -1){
                    System.out.println("You must enter more money for that purchase");
                    break;
                }
                else {
                    item.makeNoise();
                    funds.subtractMoney(item.getCost());
                    System.out.println(item.getName() + " | $" + item.getCost() + " | $" + funds.getTotalPaid() + " dollars remaining");
                    item.subtractFromInventory();


                    logMaker(funds, item);

                }

            }

        }
    }

    public String getFormattedDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        String properDateFormat = LocalDateTime.now().format(formatter);
        return properDateFormat;

    }

    public void logMaker(Funds funds, VendableItem item){

        try {
            File outputFile = new File("log.txt");
            outputFile.createNewFile();
            FileOutputStream output = new FileOutputStream(outputFile, true);
            PrintWriter writer = new PrintWriter(output);

            String dateExperiment = getFormattedDate();

            BigDecimal beforePurchaseFunds = new BigDecimal(0);
            beforePurchaseFunds = funds.getTotalPaid().add(item.getCost());


            String lineToReturn = dateExperiment + " | " + item.getName() + " | " + item.getSlot() + " | $" + beforePurchaseFunds + " | $" + funds.getTotalPaid() + "\n";
            writer.append(lineToReturn);
            writer.flush();
            writer.close();


        } catch (Exception e) {

        }

    }

}


