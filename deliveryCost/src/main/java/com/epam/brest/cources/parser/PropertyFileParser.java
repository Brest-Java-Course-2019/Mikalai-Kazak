package com.epam.brest.cources.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * The type Property file parser.
 */
public class PropertyFileParser implements FileParser<Integer, BigDecimal> {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Map<Integer, BigDecimal> getMapFromFile(String filePath) throws IOException {
        LOGGER.debug("getMapFromFile({})", filePath);
        InputStream inputStream = PropertyFileParser.class.getClassLoader()
                .getResourceAsStream(filePath);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.entrySet().stream().collect(
                Collectors.toMap(e -> Integer.parseInt(e.getKey().toString()),
                        e -> new BigDecimal(e.getValue().toString())));
    }
}
