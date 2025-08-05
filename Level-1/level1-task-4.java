import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    // Define character sets
    static final String NUMBERS = "0123456789";
    static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Password Generator");
        System.out.println("------------------");

        // Ask user for password length
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (length <= 0) {
            System.out.println("Password length must be greater than 0.");
            return;
        }

        // Ask user what character types to include
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLower = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUpper = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.nextLine().equalsIgnoreCase("yes");

        // Build character pool
        String charPool = "";
        if (includeNumbers) charPool += NUMBERS;
        if (includeLower) charPool += LOWERCASE;
        if (includeUpper) charPool += UPPERCASE;
        if (includeSpecial) charPool += SPECIAL_CHARS;

        // Validate character pool
        if (charPool.isEmpty()) {
            System.out.println("Error: No character types selected. Cannot generate password.");
            return;
        }

        // Generate password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        // Display password
        System.out.println("Generated Password: " + password);

        scanner.close();
    }
}
