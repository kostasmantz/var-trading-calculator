package com.mantzavelas.vartradingcalculator.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mantzavelas.vartradingcalculator.domain.Trade;

public class VarUtil {

    public static double calculateVaR(Trade trade, double confidenceLevel) {
        if (confidenceLevel < 0.95 || trade == null || trade.getHistoricalPLValues().isEmpty()) {
            return -1;
        }

        List<Double> historicalPLValues = trade.getHistoricalPLValues();
        
        Collections.sort(historicalPLValues);
        int index = (int) Math.ceil((1 - confidenceLevel) * historicalPLValues.size()) - 1;
        
        return historicalPLValues.get(index);
    }

    public static double calculatePortfolioVaR(List<Trade> portfolio, double confidenceLevel) {
        if (confidenceLevel < 0.95 || portfolio == null || portfolio.isEmpty()) {
            return -1;
        }

        List<Double> combinedPLValues = new ArrayList<>();

        for (Trade trade : portfolio) {
            combinedPLValues.addAll(trade.getHistoricalPLValues());
        }

        Collections.sort(combinedPLValues);
        int index = (int) Math.ceil((1 - confidenceLevel) * combinedPLValues.size()) - 1;
        
        return combinedPLValues.get(index);
    }
}
