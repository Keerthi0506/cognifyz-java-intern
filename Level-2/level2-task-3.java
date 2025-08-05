import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {

    private static final int SHIFT_KEY = 3; // Caesar cipher key

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("📁 File Encryption/Decryption Program");
        System.out.print("Do you want to (E)ncrypt or (D)ecrypt?: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter the full path to the input text file: ");
        String inputFilePath = scanner.nextLine();

        String outputFilePath;
        if (choice.equals("E")) {
            outputFilePath = inputFilePath.replace(".txt", "_encrypted.txt");
            processFile(inputFilePath, outputFilePath, SHIFT_KEY);
            System.out.println("✅ File encrypted successfully: " + outputFilePath);
        } else if (choice.equals("D")) {
            outputFilePath = inputFilePath.replace(".txt", "_decrypted.txt");
            processFile(inputFilePath, outputFilePath, -SHIFT_KEY);
            System.out.println("✅ File decrypted successfully: " + outputFilePath);
        } else {
            System.out.println("❌ Invalid choice. Please enter E or D.");
        }

        scanner.close();
    }

    private static void processFile(String inputFilePath, String outputFilePath, int shift) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = shiftText(line, shift);
                writer.write(processedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char shifted = (char) ((ch - base + shift + 26) % 26 + base);
                result.append(shifted);
            } else {
                result.append(ch); // Leave non-letters unchanged
            }
        }

        return result.toString();
    }
}
