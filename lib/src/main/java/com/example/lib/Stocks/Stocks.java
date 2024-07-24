package com.example.lib.Stocks;

public class Stocks extends SharedAssets{

    private int totalShares;

    public Stocks(String symbol, double currentPrivate) {
        super(symbol, currentPrivate);
        totalShares=0;
    }

    @Override
    public double getMarketValue() {
        return totalShares*getCurrentPrice();
    }

    public int getTotalShares() {
        return totalShares;
    }

    public void purchase(int share, double pricePerShare){
        totalShares += share;
        addCost(share * pricePerShare);
    }
}
