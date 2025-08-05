import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of grades: ");
        int n = scanner.nextInt();
        int[] grades = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            sum += grades[i];
        }
        double average = (double) sum / n;
        System.out.println("Average grade: " + average);
        scanner.close();
    }
}
