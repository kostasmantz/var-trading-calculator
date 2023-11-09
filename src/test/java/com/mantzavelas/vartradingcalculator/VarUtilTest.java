package com.mantzavelas.vartradingcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mantzavelas.vartradingcalculator.domain.Trade;
import com.mantzavelas.vartradingcalculator.utils.VarUtil;

class VarUtilTest {

    @Test
    void calculateVar_givenInvalidConfidenceLevel_shouldReturnInvalidVar() {
        //given
        double confidenceLevel = 0.85;
        Trade trade = new Trade(List.of(2.1, 2.2));

        //when
        double var = VarUtil.calculateVaR(trade, confidenceLevel);
        
        //then
        assertEquals(-1, var);
    }

    @Test
    void calculateVar_givenNullTrade_shouldReturnInvalidVar() {
        //given
        double confidenceLevel = 0.99;

        //when
        double var = VarUtil.calculateVaR(null, confidenceLevel);
        
        //then
        assertEquals(-1, var);
    }

    @Test
    void calculateVar_givenEmptyTradeHistoricalData_shouldReturnInvalidVar() {
        //given
        double confidenceLevel = 0.99;
        Trade trade = new Trade(List.of());

        //when
        double var = VarUtil.calculateVaR(trade, confidenceLevel);
        
        //then
        assertEquals(-1, var);
    }

    @Test
    void calculateVar_givenValidTradeHistoricalDataAndConfidenceLevel_shouldReturnValidVar() {
        //given
        double confidenceLevel = 0.99;
        Trade trade = new Trade(new ArrayList<>(List.of(53.3, 12.3, 321.2, 32.12, 57.8)));

        //when
        double var = VarUtil.calculateVaR(trade, confidenceLevel);
        
        //then
        assertEquals(12.3, var);
    }

    @Test
    void calculatePortfolioVaR_givenInvalidConfidenceLevel_shouldReturnInvalidVar() {
        //given
        double confidenceLevel = 0.85;
        List<Trade> trade = new ArrayList<>(
            List.of(
                new Trade(List.of(2.1, 2.2))
            )
        );

        //when
        double var = VarUtil.calculatePortfolioVaR(trade, confidenceLevel);
        
        //then
        assertEquals(-1, var);
    }

    @Test
    void calculatePortfolioVaR_givenNullTrade_shouldReturnInvalidVar() {
        //given
        double confidenceLevel = 0.85;

        //when
        double var = VarUtil.calculatePortfolioVaR(null, confidenceLevel);
        
        //then
        assertEquals(-1, var);
    }

    @Test
    void calculatePortfolioVaR_givenEmptyTradeHistoricalData_shouldReturnInvalidVar() {
        //given
        double confidenceLevel = 0.85;
        List<Trade> trade = List.of();

        //when
        double var = VarUtil.calculatePortfolioVaR(trade, confidenceLevel);
        
        //then
        assertEquals(-1, var);
    }

    @Test
    void calculatePortfolioVaR_givenValidConfidenceLevelAndHistoricalData_shouldReturnValidVar() {
        //given
        double confidenceLevel = 0.95;
        List<Trade> trade = new ArrayList<>(
            List.of(
                new Trade(List.of(2.1, 2.2, 23.1, 321.2)),
                new Trade(List.of(12.1, 5.2, 13.1, 31.2)),
                new Trade(List.of(2.5, 4.2, 21.1, 621.2))
            )
        );

        //when
        double var = VarUtil.calculatePortfolioVaR(trade, confidenceLevel);
        
        //then
        assertEquals(2.1, var);
    }
}
