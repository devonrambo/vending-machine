package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test
    public void testing_constructor() {
        Chips test = new Chips("Cheetos", new BigDecimal(3), "C5");

        String expectedName = "Cheetos";
        String expectedSlot = "C5";
        BigDecimal expectedPrice = new BigDecimal(3);

        String actualName = test.getName();
        String actualSlot = test.getSlot();
        BigDecimal actualPrice = test.getCost();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSlot,actualSlot );
        Assert.assertEquals(expectedPrice, actualPrice);

    }

}