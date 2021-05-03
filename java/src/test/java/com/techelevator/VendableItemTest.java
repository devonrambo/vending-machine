package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendableItemTest {

    @Test
    public void testing_starting_inventory_equals_five(){

        Drink item1 = new Drink("Coke", new BigDecimal(2), "A4");



        int expectedInventory = 5;
        int realInventory = item1.getAmountOf();

        Assert.assertEquals(expectedInventory, realInventory);


    }

    @Test
    public void testing_subtracting_from_inventory(){
        Chips item2 = new Chips("Cheetos", new BigDecimal(2), "A4");

        item2.subtractFromInventory();

        int expectedInventory = 4;
        int actualInventory = item2.getAmountOf();

        Assert.assertEquals(expectedInventory, actualInventory);
    }

    @Test
    public void testing_noises_made_when_purchasing_items(){

        Gum item3 = new Gum("Bubbleicious", new BigDecimal(2), "A4");
        Candy item4 = new Candy("Skittles", new BigDecimal(2), "A4");

        String expectedNoise3 = "Chew";
        String expectedNoise4 = "Munch";

        item3.makeNoise();
        item4.makeNoise();

        String actualNoise3 = item3.getNoiseMade();
        String actualNoise4 = item4.getNoiseMade();

        Assert.assertEquals(actualNoise3, expectedNoise3);
        Assert.assertEquals(actualNoise4, expectedNoise4);

    }

    @Test
    public void testing_getters(){

        Drink test = new Drink("Sprite", new BigDecimal(5), "A2");

        String expectedName = "Sprite";
        String expectedSlot = "A2";
        BigDecimal expectedPrice = new BigDecimal(5);
        int expectedAmt = 5;

        String actualName = test.getName();
        String actualSlot = test.getSlot();
        BigDecimal actualPrice = test.getCost();
        int actualAmt = test.getAmountOf();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSlot,actualSlot );
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedAmt, actualAmt);

    }



}