import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter E to Encrypt or D to Decrypt: ");
        char choice = scanner.next().toUpperCase().charAt(0);

        System.out.print("Enter input file name: ");
        String inputFile = scanner.next();

        System.out.print("Enter output file name: ");
        String outputFile = scanner.next();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            int c;
            while ((c = reader.read()) != -1) {
                if (choice == 'E') {
                    writer.write(c + 1); // Simple encryption: shift char +1
                } else if (choice == 'D') {
                    writer.write(c - 1); // Simple decryption: shift char -1
                } else {
                    System.out.println("Invalid option.");
                    reader.close();
                    writer.close();
                    return;
                }
            }

            reader.close();
            writer.close();
            System.out.println("Operation completed successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
