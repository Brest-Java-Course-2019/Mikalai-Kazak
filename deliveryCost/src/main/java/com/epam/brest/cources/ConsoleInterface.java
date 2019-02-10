package com.epam.brest.cources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The type Console interface.
 */
public class ConsoleInterface {

    private static final Logger LOGGER = LogManager.getLogger();

    private Scanner scanner;

    /**
     * Instantiates a new Console interface.
     */
    public ConsoleInterface() {
        this.scanner = new Scanner(System.in);
    }

    public BigDecimal receiveValueFromConsole(String message) {
        LOGGER.debug("receiveValueFromConsole({})", message);
        BigDecimal inputValue;
        do {
            System.out.println(message);
            inputValue = scanner.nextBigDecimal();
        } while (!checkInputValue(inputValue));
        return inputValue;
    }

    /**
     * Check input value boolean.
     *
     * @param inputValue the input value
     * @return the boolean
     */
    public boolean checkInputValue(BigDecimal inputValue) {
        LOGGER.debug("checkInputValue({})", inputValue);
        if (inputValue != null && inputValue.signum() > 0) {
            return true;
        } else {
            LOGGER.info("Input value cannot be negative");
            return false;
        }
    }

}
