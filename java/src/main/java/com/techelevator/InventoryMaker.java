package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryMaker {


    private File newFile = new File("vendingmachine.csv");

    private List<VendableItem> inventory = new ArrayList<VendableItem>();

    public void addItem(VendableItem item) {
        inventory.add(item);
    }

    public List<VendableItem> getInventory() {
        return inventory;
    }

    public void fillUp() {

        try (Scanner scanner = new Scanner(newFile)) {

            while (scanner.hasNext()) {

                String line = scanner.nextLine();

                String[] arr = line.split("\\|");
                String slot = arr[0];
                String name = arr[1];
                BigDecimal price = new BigDecimal(arr[2]);
                String type = arr[3];

                if (type.equals("Chip")) {
                    // create a new instance of class chip
                    // use all of our variables
                    Chips item = new Chips(name, price, slot);
                    inventory.add(item);


                } else if (type.equals("Drink")) {
                    Drink item = new Drink(name, price, slot);
                    inventory.add(item);

                    // create a new instance of class drink
                } else if (type.equals("Candy")) {
                    // create a new instance of class candy
                    Candy item = new Candy(name, price, slot);
                    inventory.add(item);

                } else if (type.equals("Gum")) {
                    // create a new instance of class gum
                    Gum item = new Gum(name, price, slot);
                    inventory.add(item);

                }

                // add all items into the class inventory


            }

        } catch (Exception e) {

        }
    }


}




