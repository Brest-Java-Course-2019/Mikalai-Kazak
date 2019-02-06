package com.epam.brest.cources.service;

import com.epam.brest.cources.parser.FileParser;
import com.epam.brest.cources.parser.PropertyFileParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Coefficient selector.
 */
public class CoefficientSelector {

  private static final Logger LOGGER = LogManager.getLogger();

  private Map<Integer, BigDecimal> valuesMap;

  /**
   * Select coefficient value from file big decimal.
   *
   * @param filePath the file path
   * @param targetValue the target value
   * @return the big decimal
   * @throws IOException the io exception
   */
  public BigDecimal selectCoefficientValueFromFile(String filePath,
      BigDecimal targetValue) throws IOException {

    LOGGER.debug("selectCoefficientValueFromFile({}, {}", filePath, targetValue);
    FileParser<Integer, BigDecimal> fileParser = new PropertyFileParser();
    valuesMap = fileParser.getMapFromFile(filePath);
    SortedSet<Integer> sortedKeys = new TreeSet<>(valuesMap.keySet());
    Integer foundedKey = sortedKeys.first();
    for (Integer key : sortedKeys) {
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