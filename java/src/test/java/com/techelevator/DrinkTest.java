package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void testing_constructor() {
        Drink test = new Drink("Sprite", new BigDecimal(5), "A2");

        String expectedName = "Sprite";
        String expectedSlot = "A2";
        BigDecimal expectedPrice = new BigDecimal(5);

        String actualName = test.getName();
        String actualSlot = test.getSlot();
        BigDecimal actualPrice = test.getCost();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSlot,actualSlot );
        Assert.assertEquals(expectedPrice, actualPrice);

    }

}