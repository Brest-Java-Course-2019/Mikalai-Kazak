package com.epam.brest.cources;

import com.epam.brest.cources.calculator.Calculator;
import com.epam.brest.cources.calculator.CalculatorImpl;
import com.epam.brest.cources.item.DeliveryData;
import java.math.BigDecimal;

/**
 * The type Runner.
 */
public class Runner {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        ConsoleInterface consoleInterface = new ConsoleInterface();
        DeliveryData deliveryData;
        try {
            deliveryData = consoleInterface.getDeliveryData();
            BigDecimal totalPrice = calculator.calculateCost(deliveryData);
            System.out.println("Total price = " + totalPrice.toPlainString() + "$");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
