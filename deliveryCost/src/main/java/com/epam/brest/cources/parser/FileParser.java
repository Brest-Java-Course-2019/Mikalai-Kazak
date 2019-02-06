package com.epam.brest.cources.parser;

import java.io.IOException;
import java.util.Map;

/**
 * The interface File parser.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public interface FileParser<K, V> {

  /**
   * Gets map from file.
   *
   * @param filePath the file path
   * @return the map from file
   * @throws IOException the io exception
   */
  Map<K, V> getMapFromFile(String filePath) throws IOException;
}
