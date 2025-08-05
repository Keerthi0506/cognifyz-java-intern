import java.util.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean lower = scanner.nextBoolean();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean upper = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean numbers = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean special = scanner.nextBoolean();
        String lowerSet = "abcdefghijklmnopqrstuvwxyz";
        String upperSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberSet = "0123456789";
        String specialSet = "!@#$%^&*()-_=+<>?";

        StringBuilder allChars = new StringBuilder();
        if (lower) allChars.append(lowerSet);
        if (upper) allChars.append(upperSet);
        if (numbers) allChars.append(numberSet);
        if (special) allChars.append(specialSet);

        if (allChars.length() == 0) {
            System.out.println("No character types selected!");
            scanner.close();
            return;
        }

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(allChars.length());
            password.append(allChars.charAt(index));
        }

        System.out.println("Generated password: " + password.toString());
        scanner.close();
    }
}
