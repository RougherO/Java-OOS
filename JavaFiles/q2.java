import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Student student = new Student();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();

            System.out.print("Enter marks for Subject 1: ");
            double marks1 = scanner.nextDouble();

            System.out.print("Enter marks for Subject 2: ");
            double marks2 = scanner.nextDouble();

            System.out.print("Enter marks for Subject 3: ");
            double marks3 = scanner.nextDouble();

            student.initialize(studentName, marks1, marks2, marks3);

            double average = student.calculateAverage();

            student.displayStudentDetails();
            System.out.println("Average Marks: " + average);
        }
    }
}

class Student {
    private String name;
    private double marksSubject1;
    private double marksSubject2;
    private double marksSubject3;

    public void initialize(String studentName, double marks1, double marks2, double marks3) {
        name = studentName;
        marksSubject1 = marks1;
        marksSubject2 = marks2;
        marksSubject3 = marks3;
    }

    public double calculateAverage() {
        return (marksSubject1 + marksSubject2 + marksSubject3) / 3.0;
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Total Marks: " + (marksSubject1 + marksSubject2 + marksSubject3));
    }
}