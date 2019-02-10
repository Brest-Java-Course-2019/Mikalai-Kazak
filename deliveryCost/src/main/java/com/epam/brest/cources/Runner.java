package com.epam.brest.cources;

import com.epam.brest.cources.calculator.Calculator;
import com.epam.brest.cources.item.DeliveryData;
import com.epam.brest.cources.service.CoefficientSelector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;


/**
 * The type Runner.
 */
public class Runner {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PREFIX = "Enter ";
    private static final String[] MESSAGES = {"weight in kg", "distance in km"};
    private static final String PROPERTY_FILE = "cst.properties";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context-config.xml");

        ConsoleInterface consoleInterface = new ConsoleInterface();
        DeliveryData deliveryData = (DeliveryData) applicationContext.getBean("deliveryData");
        BigDecimal weight = consoleInterface.receiveValueFromConsole(PREFIX + MESSAGES[0]);
        deliveryData.setWeight(weight);
        BigDecimal distance = consoleInterface.receiveValueFromConsole(PREFIX + MESSAGES[1]);
        deliveryData.setDistance(distance);

        try {
            CoefficientSelector coefficientSelector = new CoefficientSelector();
            BigDecimal coefficient = coefficientSelector
                    .selectCoefficientValueFromFile(PROPERTY_FILE, weight);
            deliveryData.setCoefficient(coefficient);
            Calculator calculator = (Calculator) applicationContext.getBean("deliveryCalculator");
            BigDecimal totalPrice = calculator.calculateCost(deliveryData);
            LOGGER.info("Total price = {}$", totalPrice.toPlainString());
        } catch (Exception e) {
            LOGGER.error("An error has occurred: {}", e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}