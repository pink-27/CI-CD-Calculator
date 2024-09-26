package org.example;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("event=application_start status=success message='Starting the calculator application'");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter operation (1: sqrt, 2: factorial, 3: log, 4: power, 0: exit): ");
            String input = sc.nextLine().trim();
            try {
                int operation = Integer.parseInt(input);
                logger.info("event=operation_selected operation={} status=success", operation);

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
                        logger.info("event=application_exit status=success message='Exiting the application'");
                        return;
                    default:
                        logger.warn("event=invalid_operation operation={} status=failure message='Invalid operation selected'", operation);
                        System.out.println("Invalid operation. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                logger.error("event=invalid_input input='{}' status=failure message='Invalid input for operation' error_type={}", input, e.getClass().getSimpleName());
                System.out.println("Invalid input. Please enter a valid integer for the operation.");
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
            logger.info("event=sqrt_calculation operand={} result={} status=success", operand, result);
        } catch (NumberFormatException e) {
            logger.error("event=sqrt_calculation input='{}' status=failure message='Invalid input for sqrt operation' error_type={}", input, e.getClass().getSimpleName());
            System.out.println("Error: Please enter a valid number for square root calculation.");
        } catch (IllegalArgumentException e) {
            logger.error("event=sqrt_calculation input={} status=failure message='{}' error_type={}", input, e.getMessage(), e.getClass().getSimpleName());
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
            for (int i = 2; i <= operand; i++) result *= i;
            System.out.println(result);
            logger.info("event=factorial_calculation operand={} result={} status=success", operand, result);
        } catch (NumberFormatException e) {
            logger.error("event=factorial_calculation input='{}' status=failure message='Invalid input for factorial operation' error_type={}", input, e.getClass().getSimpleName());
            System.out.println("Error: Please enter a valid integer for factorial calculation.");
        } catch (IllegalArgumentException e) {
            logger.error("event=factorial_calculation input={} status=failure message='{}' error_type={}", input, e.getMessage(), e.getClass().getSimpleName());
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
            logger.info("event=log_calculation operand={} result={} status=success", operand, result);
        } catch (NumberFormatException e) {
            logger.error("event=log_calculation input='{}' status=failure message='Invalid input for logarithm operation' error_type={}", input, e.getClass().getSimpleName());
            System.out.println("Error: Please enter a valid number for logarithm calculation.");
        } catch (IllegalArgumentException e) {
            logger.error("event=log_calculation input={} status=failure message='{}' error_type={}", input, e.getMessage(), e.getClass().getSimpleName());
            System.out.println("Error: " + e.getMessage());
        }
    }

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
            logger.info("event=power_calculation base={} exponent={} result={} status=success", base, exponent, result);
        } catch (NumberFormatException e) {
            logger.error("event=power_calculation status=failure message='Invalid input for power operation' error_type={}", e.getClass().getSimpleName());
            System.out.println("Error: Please enter valid numbers for the power calculation.");
        }
    }
}