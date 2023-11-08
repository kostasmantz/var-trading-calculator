package com.mantzavelas.vartradingcalculator;

import java.util.List;

import com.mantzavelas.vartradingcalculator.domain.Trade;
import com.mantzavelas.vartradingcalculator.services.TradeDataLoader;
import com.mantzavelas.vartradingcalculator.utils.VarUtil;

public class VarCalculator {

   public static void main(String[] args) {
      List<Double> data = new TradeDataLoader().getTradeHistoricalData();
      Trade trade = new Trade(data);
      double confidenceLevel = 0.95;

      double result = VarUtil.calculateVaR(trade, confidenceLevel);
      System.out.println("VaR: " + result);
   }
}