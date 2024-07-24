package com.example.lib.Stocks;

public class Cash implements Asset{

    private double amount;

    public Cash(double amount) {
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public double getMarketValue() {
        return amount;
    }

    @Override
    public double getProfit() {
        return 0;
    }
}
