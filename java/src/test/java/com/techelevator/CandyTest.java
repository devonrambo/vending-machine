package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void testing_constructor() {
        Candy test = new Candy("Snickers", new BigDecimal(5), "A5");

        String expectedName = "Snickers";
        String expectedSlot = "A5";
        BigDecimal expectedPrice = new BigDecimal(5);

        String actualName = test.getName();
        String actualSlot = test.getSlot();
        BigDecimal actualPrice = test.getCost();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSlot,actualSlot );
        Assert.assertEquals(expectedPrice, actualPrice);

    }






}