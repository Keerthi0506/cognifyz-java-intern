import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("----------------------");
        System.out.print("Enter the temperature (e.g., 32C or 100F): ");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.endsWith("C")) {
            try {
                double celsius = Double.parseDouble(input.substring(0, input.length() - 1));
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.printf("%.2f°C is equal to %.2f°F%n", celsius, fahrenheit);
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature value. Please enter a number followed by 'C'.");
            }
        } else if (input.endsWith("F")) {
            try {
                double fahrenheit = Double.parseDouble(input.substring(0, input.length() - 1));
                double celsius = (fahrenheit - 32) * 5 / 9;
                System.out.printf("%.2f°F is equal to %.2f°C%n", fahrenheit, celsius);
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature value. Please enter a number followed by 'F'.");
            }
        } else {
            System.out.println("Invalid input. Please end your input with 'C' for Celsius or 'F' for Fahrenheit.");
        }

        scanner.close();
    }
}
