import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeTracker {
    private Map<String, List<Double>> studentGrades;

    public StudentGradeTracker() {
        studentGrades = new HashMap<>();
    }

    public void addStudent(String name) {
        if (!studentGrades.containsKey(name)) {
            studentGrades.put(name, new ArrayList<>());
            System.out.println("Student " + name + " added.");
        } else {
            System.out.println("Student " + name + " already exists.");
        }
    }

    public void addGrade(String name, double grade) {
        if (studentGrades.containsKey(name)) {
            studentGrades.get(name).add(grade);
            System.out.println("Grade " + grade + " added for " + name + ".");
        } else {
            System.out.println("Student " + name + " does not exist.");
        }
    }

    public void displayAverageGrade(String name) {
        if (studentGrades.containsKey(name)) {
            List<Double> grades = studentGrades.get(name);
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            double average = grades.size() > 0 ? sum / grades.size() : 0;
            System.out.println("Average grade for " + name + ": " + average);
        } else {
            System.out.println("Student " + name + " does not exist.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Display Average Grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    tracker.addStudent(studentName);
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    studentName = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    tracker.addGrade(studentName, grade);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    studentName = scanner.nextLine();
                    tracker.displayAverageGrade(studentName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
