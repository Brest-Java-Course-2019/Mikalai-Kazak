package com.epam.brest.cources.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.IOException;
import com.epam.brest.cources.parser.FileParser;
import com.epam.brest.cources.parser.PropertyFileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoefficientSelector {

    private static final Logger LOGGER = LogManager.getLogger();

    private Map<Integer, BigDecimal> valuesMap;

    public BigDecimal selectCoefficientValueFromFile(String filePath, 
            BigDecimal targetValue) throws IOException {

        LOGGER.debug("selectCoefficientValueFromFile({}, {}", filePath, targetValue);
        FileParser<Integer, BigDecimal> fileParser = new PropertyFileParser();
        valuesMap = fileParser.getMapFromFile(filePath);
        SortedSet<Integer> sortedKeys = new TreeSet<>(valuesMap.keySet());
        Integer foundedKey = sortedKeys.first();
        for(Integer key : sortedKeys) {
            if (foundedKey >= targetValue.doubleValue()) {
                break;
            }
            foundedKey = key;
        }

        BigDecimal foundedValue = valuesMap.get(foundedKey);
        LOGGER.info("Selected interval for value {} is {} -> {}", 
            targetValue, foundedKey, foundedValue);
        return foundedValue;
    }
}