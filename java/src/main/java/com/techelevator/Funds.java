package com.techelevator;

import java.math.BigDecimal;

public class Funds {

    private BigDecimal moneyBeforeAction = new BigDecimal(0);

    private BigDecimal totalPaid = new BigDecimal(0);

    public BigDecimal getMoneyBeforeAction() {
        return this.moneyBeforeAction;
    }

    public void addMoney(BigDecimal addedMoney){
        moneyBeforeAction = this.totalPaid;
        this.totalPaid = this.totalPaid.add(addedMoney);
    }

    public void subtractMoney(BigDecimal subtractedMoney){
        moneyBeforeAction = this.totalPaid;
        this.totalPaid = this.totalPaid.subtract(subtractedMoney);
    }

    public BigDecimal getTotalPaid() {
        return this.totalPaid;
    }
}
