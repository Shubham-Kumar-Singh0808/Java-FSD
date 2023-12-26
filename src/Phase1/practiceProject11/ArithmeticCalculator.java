package practiceProject11;

import java.util.Scanner;

public class ArithmeticCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Arithmetic Calculator!");

        while (true) {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Choose operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            double result = calculate(num1, num2, operation);
            System.out.println("Result: " + result);

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String continueCalculation = scanner.next().toLowerCase();

            if (!continueCalculation.equals("yes")) {
                System.out.println("Thank you for using Arithmetic Calculator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static double calculate(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero. Please enter a non-zero second number.");
                    return Double.NaN;
                }
            default:
                System.out.println("Error: Invalid operation. Please enter a valid operation (+, -, *, /).");
                return Double.NaN;
        }
    }
}

