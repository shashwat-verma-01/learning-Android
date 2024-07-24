package com.example.lib.Stocks;

public class CodeTest {
    public static void main(String[] args) {
        Asset asset = new MutualFunds("AMZ", 300);
        System.out.println(asset.getMarketValue());
    }
}
