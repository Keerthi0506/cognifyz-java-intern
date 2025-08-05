import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit (C/F): ");
        char unit = scanner.next().toUpperCase().charAt(0);
        if (unit == 'C') {
            double fahrenheit = (temperature * 9 / 5) + 32;
            System.out.println("Converted to Fahrenheit: " + fahrenheit + "°F");
        } else if (unit == 'F') {
            double celsius = (temperature - 32) * 5 / 9;
            System.out.println("Converted to Celsius: " + celsius + "°C");
        } else {
            System.out.println("Invalid unit. Please enter C or F.");
        }
        scanner.close();
    }
}
