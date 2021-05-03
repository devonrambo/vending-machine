package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FundsTest {


    @Test
    public void testing_subtracting_funds(){


        Funds funds = new Funds();

        funds.subtractMoney(new BigDecimal(20));

        BigDecimal expectedFunds = new BigDecimal(-20);

        BigDecimal actualFunds = funds.getTotalPaid();

        assertEquals(expectedFunds, actualFunds);

    }

    @Test
    public void testing_adding_funds(){
        Funds funds = new Funds();

        funds.addMoney(new BigDecimal(50));

        BigDecimal expectedFunds = new BigDecimal(50);

        BigDecimal actualFunds = funds.getTotalPaid();

        assertEquals(expectedFunds, actualFunds);


    }

}