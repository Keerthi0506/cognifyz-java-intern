import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
        if (Character.isUpperCase(ch)) hasUpper = true;
        else if (Character.isLowerCase(ch)) hasLower = true;
        else if (Character.isDigit(ch)) hasDigit = true;
        else hasSpecial = true;
}
        if (password.length() >= 8 && hasUpper && hasLower && hasDigit && hasSpecial) {
              System.out.println(" Strong password");
        } else if (password.length() >= 6 && ((hasUpper && hasLower) || (hasLower && hasDigit))) {
              System.out.println(" Medium password");
        } else {
              System.out.println(" Weak password");
}

    }
}
