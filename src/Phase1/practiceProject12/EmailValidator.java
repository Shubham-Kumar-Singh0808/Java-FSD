package practiceProject12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Email Validator!");

        while (true) {
            System.out.print("Enter an email address: ");
            String email = scanner.nextLine();

            boolean isValid = validateEmail(email);

            if (isValid) {
                System.out.println("The entered email address is valid.");
            } else {
                System.out.println("The entered email address is not valid. Please enter a valid email.");
            }

            System.out.print("Do you want to validate another email? (yes/no): ");
            String continueValidation = scanner.nextLine().toLowerCase();

            if (!continueValidation.equals("yes")) {
                System.out.println("Thank you for using Email Validator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
