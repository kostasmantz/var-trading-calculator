package com.mantzavelas.vartradingcalculator.domain;

import java.util.List;

public class Trade {

    private List<Double> historicalPLValues;

    public Trade(List<Double> historicalPLValues) {
        this.historicalPLValues = historicalPLValues;
    }

    public List<Double> getHistoricalPLValues() {
        return historicalPLValues;
    }

    public void setHistoricalPLValues(List<Double> historicalPLValues) {
        this.historicalPLValues = historicalPLValues;
    }

}
