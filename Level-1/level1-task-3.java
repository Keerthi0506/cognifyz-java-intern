import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");
        System.out.println("------------------------");

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        // Input validation
        if (numGrades <= 0) {
            System.out.println("Please enter a positive number of grades.");
            return;
        }

        double[] grades = new double[numGrades];
        double sum = 0;

        // Loop to collect grades
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();

            // Optional: validate grade input (0 to 100)
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Grade should be between 0 and 100. Please re-enter.");
                i--; // repeat this iteration
            } else {
                sum += grades[i];
            }
        }

        // Calculate average
        double average = sum / numGrades;

        // Display result
        System.out.printf("Average Grade: %.2f%n", average);

        scanner.close();
    }
}
