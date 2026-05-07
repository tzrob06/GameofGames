import java.util.Scanner;

public class GetInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static int getIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = SCANNER.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    public static char getCharInput(String prompt, char[] validChars) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                char value = input.charAt(0);
                for (char valid : validChars) {
                    if (value == valid) {
                        return value;
                    }
                }
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static String getStringOptions(String prompt, String option1, String option2) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim().toUpperCase();
            if (input.equals(option1.toUpperCase()) || input.equals(option2.toUpperCase())) {
                return input;
            }
            System.out.println("Invalid choice. Please enter " + option1 + " or " + option2 + ".");
        }
    }
    
    public static int getOddIntInput(String prompt, int min, int max) {
        while (true) {
            int value = getIntInRange(prompt, min, max);
            if (value % 2 != 0) {
                return value;
            }
            System.out.println("Invalid choice. Please enter an ODD number.");
        }
    }
    
    public static char getYesNoInput(String prompt) {
        return getCharInput(prompt, new char[]{'Y', 'N'});
    }
    
    // Changed from waitForEnter to pressEnter to match FindTheRedThread
    public static void pressEnter(String prompt) {
        System.out.print(prompt);
        SCANNER.nextLine();
    }
}