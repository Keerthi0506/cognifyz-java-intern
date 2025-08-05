import java.util.Scanner;

public class PalindromeChecker {

    // Method to clean the input: remove non-letter characters and convert to lowercase
    public static String cleanInput(String input) {
        return input.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    // Method to check if the cleaned string is a palindrome
    public static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Palindrome Checker");
        System.out.println("------------------");
        System.out.print("Enter a word or phrase: ");
        String originalInput = scanner.nextLine();

        String cleanedInput = cleanInput(originalInput);

        if (cleanedInput.isEmpty()) {
            System.out.println("Input contains no valid letters.");
        } else if (isPalindrome(cleanedInput)) {
            System.out.println("✅ It's a palindrome!");
        } else {
            System.out.println("❌ It's not a palindrome.");
        }

        scanner.close();
    }
}
