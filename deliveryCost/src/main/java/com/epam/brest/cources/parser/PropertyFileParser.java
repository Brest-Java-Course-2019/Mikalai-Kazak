package com.epam.brest.cources.parser;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertyFileParser implements FileParser<String, BigDecimal> {

    @Override
    public Map<String, BigDecimal> getMapFromFile(String filePath) throws IOException {
        InputStream inputStream = PropertyFileParser.class.getClassLoader()
                .getResourceAsStream(filePath);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.entrySet().stream().collect(
                Collectors.toMap(e -> String.valueOf(e.getKey()),
                        e -> new BigDecimal(e.getValue().toString())));
    }
}
