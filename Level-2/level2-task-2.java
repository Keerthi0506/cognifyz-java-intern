import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🔐 Password Strength Checker 🔐");
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        checkPasswordStrength(password);
        scanner.close();
    }

    public static void checkPasswordStrength(String password) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean hasLength = password.length() >= 8;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        int score = 0;
        if (hasLength) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        String strength;
        switch (score) {
            case 5: strength = "Very Strong 💪"; break;
            case 4: strength = "Strong"; break;
            case 3: strength = "Moderate"; break;
            case 2: strength = "Weak"; break;
            default: strength = "Very Weak ⚠️"; break;
        }

        System.out.println("\nPassword Strength: " + strength);
        System.out.println("\nPassword Requirements:");
        System.out.println((hasLength ? "✅" : "❌") + " Length (minimum 8 characters)");
        System.out.println((hasUpper ? "✅" : "❌") + " Uppercase letter");
        System.out.println((hasLower ? "✅" : "❌") + " Lowercase letter");
        System.out.println((hasDigit ? "✅" : "❌") + " Digit");
        System.out.println((hasSpecial ? "✅" : "❌") + " Special character (e.g., @, #, !, etc.)");
    }
}
