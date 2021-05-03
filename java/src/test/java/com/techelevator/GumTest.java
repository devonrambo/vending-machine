package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void testing_constructor() {
        Gum test = new Gum("Spearmint", new BigDecimal(1), "B4");

        String expectedName = "Spearmint";
        String expectedSlot = "B4";
        BigDecimal expectedPrice = new BigDecimal(1);

        String actualName = test.getName();
        String actualSlot = test.getSlot();
        BigDecimal actualPrice = test.getCost();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSlot,actualSlot );
        Assert.assertEquals(expectedPrice, actualPrice);

    }

}