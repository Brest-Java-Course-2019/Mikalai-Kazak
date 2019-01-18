package com.nikolay.deliverycost;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUserData {

    private Scanner in;

    private double input;

    public double userInput(String msg) throws InputMismatchException {
        in = new Scanner(System.in);
        System.out.print(msg);
        input = in.nextDouble();
        return input;
    }
}
