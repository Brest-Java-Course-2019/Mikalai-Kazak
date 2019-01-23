package com.epam.brest.cources.parser;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertyFileParserImpl implements PropertyFileParser<String, BigDecimal> {

  @Override
  public Map<String, BigDecimal> getMapFromFile(String filePath) throws IOException {
    String paths = Objects
        .requireNonNull(PropertyFileParserImpl.class.getClassLoader().getResource(filePath))
        .getPath();
    Stream<String> lines = Files.lines(Paths.get(paths));
    Map<String, BigDecimal> resultMap = lines.map(line -> line.split("="))
        .collect(Collectors.toMap(line -> line[0], line -> new BigDecimal(line[1])));
    lines.close();
    return resultMap;
  }

}
