package com.example.lib.Stocks;

public class MutualFunds extends SharedAssets{
    private double totalShares;

    public MutualFunds(String symbol, double currentPrivate) {
        super(symbol, currentPrivate);
        totalShares = 0.0;
    }

    @Override
    public double getMarketValue() {
        return totalShares * getCurrentPrice();
    }

    public double getTotalShares() {
        return totalShares;
    }

    public void purchase(double shares, double pricePerShare){
        totalShares += shares;
        addCost(shares * pricePerShare);
    }
}
