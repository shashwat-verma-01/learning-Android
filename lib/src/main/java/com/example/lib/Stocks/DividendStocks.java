package com.example.lib.Stocks;

public class DividendStocks extends Stocks{
    private double dividends;
    public DividendStocks(String symbol, double currentPrivate) {
        super(symbol, currentPrivate);
        dividends = 0.0;
    }

    @Override
    public double getMarketValue() {
        return super.getMarketValue() + dividends;

    }

    public void payDividends(double amountsPerShare){
        dividends += amountsPerShare + getTotalShares();
    }
}
