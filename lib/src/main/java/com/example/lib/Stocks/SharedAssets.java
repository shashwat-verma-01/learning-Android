package com.example.lib.Stocks;

public abstract class SharedAssets implements Asset{
//    This is a redundant code
    private String symbol;
    private double totalCost;
    private double currentPrice;

    public SharedAssets(String symbol, double currentPrivate) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        totalCost = 0.0;
    }

    public void addCost(double cost){
        totalCost+=cost;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public abstract double getMarketValue();

    public double getProfit(){
        return getMarketValue()-totalCost;
    }
}
