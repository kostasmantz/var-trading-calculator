package com.mantzavelas.vartradingcalculator.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class TradeDataLoaderUtil {

    public static List<Double> getTradeHistoricalData() {
        String filePath = "pl_historical_values.csv";

        InputStream in = TradeDataLoaderUtil.class.getClassLoader().getResourceAsStream(filePath);
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
            .lines()
            .map(line -> Double.parseDouble(line))
            .collect(Collectors.toList());

    }
}
