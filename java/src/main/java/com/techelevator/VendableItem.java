package com.techelevator;

import java.math.BigDecimal;

public abstract class VendableItem {

    private BigDecimal cost;
    private String name;
    private int amountOf;
    private String slot;
    private String noiseMade = "";
    private String type = "";



    public VendableItem(BigDecimal cost, String name, int amountOf, String slot, String type) {
        this.cost = cost;
        this.name = name;
        this.amountOf = amountOf;
        this.slot = slot;
        this.type = type;
    }


    public BigDecimal getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getAmountOf() {
        return amountOf;
    }

    public String getSlot() {
        return slot;
    }

    public String getNoiseMade() {
        return this.noiseMade;
    }

    public void subtractFromInventory(){
        this.amountOf = this.amountOf - 1;
    }

    public void makeNoise(){

        if(this.type.equals("Chips")) {
            System.out.println("Crunch Crunch, Yum!");
            this.noiseMade = "Crunch";
        }
        else if(this.type.equals("Candy")){
            System.out.println("Munch Munch, Yum!");
            this.noiseMade = "Munch";
        }
        else if(this.type.equals("Drink")){
            System.out.println("Glug Glug, Yum!");
            this.noiseMade = "Glug";
        }
        else if(this.type.equals("Gum")){
            System.out.println("Chew Chew, Yum!");
            this.noiseMade = "Chew";
        }

    }

    @Override
    public String toString() {

        boolean soldOut = false;
        if(this.amountOf <= 0){
            soldOut = true;
        }

        String inStock;

        if(soldOut){
            inStock = "SOLD OUT";
        }
        else{
            inStock = String.valueOf(this.amountOf) + " in stock";
        }

        String str;
        str = "------------------------------------ \n";
        str += this.name + " | " + this.cost + " | " + this.slot + " | " + inStock;
        return str;
    }
}
