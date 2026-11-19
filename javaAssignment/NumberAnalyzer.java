package javaAssignment;

import java.util.Scanner;

/**
 * A small console program that lets the user try a few simple number
 * operations (counting down, even/odd report, sign check and addition)
 * through a menu that keeps repeating until the user chooses to exit.
 */
public class NumberAnalyzer {

    /** Shared scanner used to read everything the user types. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Entry point of the program. It shows the menu again and again with a
     * do-while loop, reads the user's choice and calls the matching method
     * until the user picks the exit option.
     *
     * @param args command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readMenuChoice();

            switch (choice) {
                case 1:
                    printNumbersDescending();
                    break;
                case 2:
                    printEvenOrOdd();
                    break;
                case 3:
                    int numberToCheck = readInteger("Enter a number: ");
                    System.out.println(checkNumberType(numberToCheck));
                    break;
                case 4:
                    int firstNumber = readInteger("Enter the first number: ");
                    int secondNumber = readInteger("Enter the second number: ");
                    System.out.println("Sum = " + calculateSum(firstNumber, secondNumber));
                    break;
                case 5:
                    System.out.println("Thank you for using Number Analyzer.");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }

    /**
     * Counts down from ten to one and shows each number on its own line.
     * It does not take any input and does not give anything back.
     */
    public static void printNumbersDescending() {
        for (int number = 10; number >= 1; number--) {
            System.out.println(number);
        }
    }

    /**
     * Goes through the numbers one to ten and, for each of them, prints
     * whether it is an even number or an odd number using the format
     * "number -> Even" or "number -> Odd".
     * It does not take any input and does not give anything back.
     */
    public static void printEvenOrOdd() {
        for (int number = 1; number <= 10; number++) {
            if (number % 2 == 0) {
                System.out.println(number + " -> Even");
            } else {
                System.out.println(number + " -> Odd");
            }
        }
    }

    /**
     * Looks at the sign of a whole number and tells what kind of number it
     * is: bigger than zero, smaller than zero, or exactly zero.
     *
     * @param number the whole number the user wants to check
     * @return the text "Positive", "Negative" or "Zero" depending on the
     *         value of the number
     */
    public static String checkNumberType(int number) {
        if (number > 0) {
            return "Positive";
        } else if (number < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }

    /**
     * Adds two whole numbers together and gives back the total.
     *
     * @param number1 the first number to be added
     * @param number2 the second number to be added
     * @return the total of number1 and number2
     */
    public static int calculateSum(int number1, int number2) {
        return number1 + number2;
    }

    /**
     * Prints the menu with all the options the user can choose from.
     */
    private static void printMenu() {
        System.out.println("=========================");
        System.out.println("Number Analyzer Menu");
        System.out.println("=========================");
        System.out.println("1 - Print Numbers 10 to 1");
        System.out.println("2 - Print Even/Odd Report");
        System.out.println("3 - Check Number Type");
        System.out.println("4 - Calculate Sum Between Two Numbers");
        System.out.println("5 - Exit");
        System.out.println("=========================");
        System.out.print("Enter your choice: ");
    }

    /**
     * Reads the menu choice from the user. If what the user typed is not a
     * whole number, a value that is not a valid option is returned so the
     * program can show the "Invalid Choice" message instead of crashing.
     *
     * @return the number typed by the user, or -1 if the input was not a
     *         whole number
     */
    private static int readMenuChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    /**
     * Shows a message and keeps asking until the user types a valid whole
     * number, which protects the program from wrong input.
     *
     * @param message the text shown to the user before reading the number
     * @return the whole number entered by the user
     */
    private static int readInteger(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
