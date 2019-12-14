package dateCalculator;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Validator {
    public static String getString(@NotNull Scanner sc, String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(sc, prompt);
            if (i < min) {
                System.out.printf("Error! Number must be %d or greater.%n", min);
            }
            else if (i > max) {
                System.out.printf("Error! Number must be %d or less.%n", max);
            }
            else {
                isValid = true;
            }
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt, int min, int max, String errMsg) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(sc, prompt);
            if (i < min || i > max) {
                prompt = errMsg;
            }
            else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(Scanner sc, String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner sc, String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(sc, prompt);
            if (d < min) {
                System.out.printf("Error! Number must be %s or greater.%n", min);
            }
            else if (d > max) {
                System.out.printf("Error! Number must be %s or less.%n", max);
            }
            else {
                isValid = true;
            }
        }
        return d;
    }
}