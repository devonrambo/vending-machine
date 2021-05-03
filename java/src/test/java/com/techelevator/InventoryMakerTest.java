package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryMakerTest {

@Test
    public void testing_inventory_size_from_data_input(){


            // creating a new instance of an inventory maker
            // filling it up which reads the input file and stocks the inventory
                // in this case the file is 16 lines our inventory makers should make a list of 16 vendable items
                InventoryMaker inventoryMaker = new InventoryMaker();
                inventoryMaker.fillUp();

                List<VendableItem> actualInventory = inventoryMaker.getInventory();

                int actualSize = actualInventory.size();
                int expectedSize = 16;

                Assert.assertEquals(actualSize, expectedSize);


    }


    @Test
    public void testing_adding_items_to_inventory(){

        InventoryMaker inventoryMaker = new InventoryMaker();
        inventoryMaker.fillUp();

        List<VendableItem> actualInventory = inventoryMaker.getInventory();

        Drink itemToAdd = new Drink("Cola", new BigDecimal(2), "A3" );

        inventoryMaker.addItem(itemToAdd);


        // checking index 16 (item 17) to see if the itemToAdd was added to the end of the 16 item list and became item 17

        VendableItem itemThatWasAdded = inventoryMaker.getInventory().get(16);

        Assert.assertEquals(itemToAdd, itemThatWasAdded);



    }

}