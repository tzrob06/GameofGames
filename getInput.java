import java.util.Scanner;


public class GetInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    
    public static int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = SCANNER.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
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
            StringBuilder validStr = new StringBuilder();
            for (int i = 0; i < validChars.length; i++) {
                validStr.append("\"").append(validChars[i]).append("\"");
                if (i < validChars.length - 1) {
                    validStr.append(" or ");
                }
            }
            System.out.println("Invalid choice. Please enter " + validStr.toString() + ": ");
        }
    }
    
   
    public static int getOddIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = SCANNER.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value >= min && value <= max && value % 2 != 0) {
                    return value;
                }
                if (value < min || value > max) {
                    System.out.println("Invalid choice. Please enter an odd number between " + min + " and " + max + ": ");
                } else {
                    System.out.println("Invalid choice. Please enter an odd number (not even): ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter an odd number between " + min + " and " + max + ": ");
            }
        }
    }
    
    
    public static char getYesNoInput(String prompt) {
        return getCharInput(prompt, new char[]{'Y', 'N'});
    }
    
    
    public static void waitForEnter(String prompt) {
        System.out.print(prompt);
        SCANNER.nextLine();
    }
}