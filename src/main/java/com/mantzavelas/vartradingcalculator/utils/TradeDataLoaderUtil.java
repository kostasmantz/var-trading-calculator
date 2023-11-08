package com.mantzavelas.vartradingcalculator.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TradeDataLoaderUtil {
    
    public static List<Double> getTradeHistoricalData() {
        String filePath = "C:\\Users\\Σπυρος\\Desktop\\projects\\var-trading-calculator\\src\\main\\java\\com\\mantzavelas\\vartradingcalculator\\pl_historical_values.csv";
        List<Double> data = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            
            lines.forEach(line -> data.add(Double.parseDouble(line)));
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
