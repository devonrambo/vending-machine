package com.techelevator;

import com.techelevator.view.Menu;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {


    private Funds funds = new Funds();

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {"Feed Money", "Select Product", "Finish Transaction"};
    private static final String[] MONEY_OPTIONS = {"$1", "$2", "$5", "$10", "Back"};

    private List<VendableItem> inventory;

    public List<VendableItem> getInventory() {
        return inventory;
    }

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {

        InventoryMaker maker = new InventoryMaker();
        maker.fillUp();
        this.inventory = maker.getInventory();


        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            System.out.println("The choice selected from the 1st level is: " + choice);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                // call method for displaying items
                displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                System.out.println("Current Money Proved: $" + funds.getTotalPaid());
                handlePurchaseOptions();


            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    public void displayItems() {

        // inventory is already stocked at this point

        for (VendableItem item : inventory) {
            System.out.println(item.toString());
        }


    }


    public void handlePurchaseOptions() {
        boolean stay = true;

        while (stay) {

            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);


            if (choice.equals("Feed Money")) {
                System.out.println("Feeding Money...");

                CashReader cashReader = new CashReader();
                cashReader.handleFeedMoney(menu, MONEY_OPTIONS, this.funds);

            } else if (choice.equals("Select Product")) {
                System.out.println("Selection Products...");
                ProductDispenser productDispenser = new ProductDispenser();
                productDispenser.handleProductSelection(inventory, this.funds);

            } else if (choice.equals("Finish Transaction")) {
                ChangeMaker changeMaker = new ChangeMaker();
                changeMaker.makeChange(funds.getTotalPaid());
                stay = false;

            }


        }

    }




        }



