package org.example;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting the calculator application");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter operation (1: sqrt, 2: factorial, 3: log, 4: power, 0: exit): ");
            String input = sc.nextLine().trim();
            int operation = -1;

            try {
                operation = Integer.parseInt(input);
                logger.info("Operation selected: {}", operation);
            } catch (NumberFormatException e) {
                logger.error("Invalid input for operation: '{}'. Error: {}", input, e.getMessage());
                System.out.println("Invalid input. Please enter a valid integer for the operation.");
                continue; // Skip the rest of the loop and prompt again
            }

            switch (operation) {
                case 1:
                    handleSqrt(sc);
                    break;
                case 2:
                    handleFactorial(sc);
                    break;
                case 3:
                    handleLog(sc);
                    break;
                case 4:
                    handlePower(sc);
                    break;
                case 0:
                    logger.info("Exiting the application");
                    sc.close(); // Close the scanner before exiting
                    return;
                default:
                    logger.warn("Invalid operation selected: {}", operation);
                    System.out.println("Invalid operation. Please select a valid option.");
            }
        }
    }

    public static void handleSqrt(Scanner sc) {
        System.out.print("Enter operand: ");
        String input = sc.nextLine().trim();
        try {
            double operand = Double.parseDouble(input);
            if (operand < 0) {
                throw new IllegalArgumentException("Square root of a negative number is not allowed.");
            }
            double result = Math.sqrt(operand);
            System.out.println(result);
            logger.info("Square root calculation: operand = {}, result = {}", operand, result);
        } catch (NumberFormatException e) {
            logger.error("Invalid input for sqrt operation: '{}'. Error: {}", input, e.getMessage());
            System.out.println("Error: Please enter a valid number for square root calculation.");
        } catch (IllegalArgumentException e) {
            logger.error("Error in sqrt calculation: {}. Input: {}", e.getMessage(), input);
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void handleFactorial(Scanner sc) {
        System.out.print("Enter operand: ");
        String input = sc.nextLine().trim();
        try {
            int operand = Integer.parseInt(input);
            if (operand < 0) {
                throw new IllegalArgumentException("Factorial of a negative number is not defined.");
            }
            long result = 1;
            for (int i = 2; i <= operand; i++) {
                result *= i;
            }
            System.out.println(result);
            logger.info("Factorial calculation: operand = {}, result = {}", operand, result);
        } catch (NumberFormatException e) {
            logger.error("Invalid input for factorial operation: '{}'. Error: {}", input, e.getMessage());
            System.out.println("Error: Please enter a valid integer for factorial calculation.");
        } catch (IllegalArgumentException e) {
            logger.error("Error in factorial calculation: {}. Input: {}", e.getMessage(), input);
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void handleLog(Scanner sc) {
        System.out.print("Enter operand: ");
        String input = sc.nextLine().trim();
        try {
            double operand = Double.parseDouble(input);
            if (operand <= 0) {
                throw new IllegalArgumentException("Logarithm of zero or negative number is not allowed.");
            }
            double result = Math.log(operand);
            System.out.println(result);
            logger.info("Logarithm calculation: operand = {}, result = {}", operand, result);
        } catch (NumberFormatException e) {
            logger.error("Invalid input for logarithm operation: '{}'. Error: {}", input, e.getMessage());
            System.out.println("Error: Please enter a valid number for logarithm calculation.");
        } catch (IllegalArgumentException e) {
            logger.error("Error in logarithm calculation: {}. Input: {}", e.getMessage(), input);
            System.out.println("Error: " + e.getMessage());
        }
    }

//test pipeline
    public static void handlePower(Scanner sc) {
        try {
            System.out.print("Enter base: ");
            String baseInput = sc.nextLine().trim();
            double base = Double.parseDouble(baseInput);

            System.out.print("Enter exponent: ");
            String exponentInput = sc.nextLine().trim();
            double exponent = Double.parseDouble(exponentInput);

            double result = Math.pow(base, exponent);
            System.out.println(result);
            logger.info("Power calculation: base = {}, exponent = {}, result = {}", base, exponent, result);
        } catch (NumberFormatException e) {
            logger.error("Invalid input for power operation. Error: {}", e.getMessage());
            System.out.println("Error: Please enter valid numbers for the power calculation.");
        }
    }
}
