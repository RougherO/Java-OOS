import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q9 {
    public static void main(String[] args) {
        Person person = new Person(25, 70.5, 175.0, new GregorianCalendar(1990, 10, 10).getTime(), "123 Main St");
        Employee employee = new Employee(30, 80.0, 180.0, new GregorianCalendar(2000, 11, 11).getTime(), "456 Oak St",
                60000, new GregorianCalendar(2003, 9, 9).getTime(), 5);
        Student student = new Student(20, 60.0, 160.0, new GregorianCalendar(1990, 10, 10).getTime(), "789 Pine St",
                101,
                List.of("Math", "Physics", "Chemistry"));
        Technician technician = new Technician(35, 75.0, 170.0, new GregorianCalendar(2000, 11, 11).getTime(),
                "101 Maple St", 70000, new GregorianCalendar(2012, 6, 6).getTime(), 8);
        Professor professor = new Professor(40, 85.0, 185.0, new GregorianCalendar(2000, 11, 11).getTime(),
                "202 Birch St", 90000, new GregorianCalendar(2012, 5, 5).getTime(), 12,
                List.of("Computer Science", "Data Science"), new ArrayList<>());

        professor.addAdvisee("John Doe");
        professor.addAdvisee("Jane Smith");
        professor.removeAdvisee("John Doe");

        System.out.println("Person Details:\n" + person);
        System.out.println();
        System.out.println("Employee Details:\n" + employee);
        System.out.println();
        System.out.println("Student Details:\n" + student);
        System.out.println();
        System.out.println("Technician Details:\n" + technician);
        System.out.println();
        System.out.println("Professor Details:\n" + professor);
    }
}

class Person {
    Person(int age, double weight, double height, Date dateOfBirth, String address) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    int getAge() {
        return age;
    }

    double getWeight() {
        return weight;
    }

    double getHeight() {
        return height;
    }

    Date getDateOfBirth() {
        return dateOfBirth;
    }

    String getAddress() {
        return address;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }

    void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Age = " + age +
                "\nWeight = " + weight +
                "\nHeight = " + height +
                "\nDate Of Birth = " + dateFormat.format(dateOfBirth) +
                "\nAddress = " + address;
    }

    private int age;
    private double weight;
    private final double height;
    private final Date dateOfBirth;
    private String address;
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
}

class Employee extends Person {
    Employee(int age, double weight, double height, Date dateOfBirth,
            String address, double salary, Date dateOfJoining, int experience) {
        super(age, weight, height, dateOfBirth, address);
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.experience = experience;
    }

    double getSalary() {
        return salary;
    }

    Date getDateOfJoining() {
        return dateOfJoining;
    }

    int getExperience() {
        return experience;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSalary = " + salary + " INR" +
                "\nDate Of Joining = " + dateFormat.format(dateOfJoining) +
                "\nExperience = " + experience + " years";
    }

    private double salary;
    private final Date dateOfJoining;
    private int experience;
}

class Student extends Person {
    Student(int age, double weight, double height, Date dateOfBirth,
            String address, int roll, List<String> listOfSubjects) {
        super(age, weight, height, dateOfBirth, address);
        this.roll = roll;
        this.listOfSubjects = listOfSubjects;
        this.marks = new HashMap<>();

        listOfSubjects.forEach((String subject) -> marks.put(subject, 0));
    }

    int getRoll() {
        return roll;
    }

    List<String> getListOfSubjects() {
        return listOfSubjects;
    }

    Map<String, Integer> getMarks() {
        return marks;
    }

    void calculateGrade() {
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRoll = " + roll +
                "\nList Of Subjects = " + listOfSubjects +
                "\nMarks = " + marks;
    }

    private final int roll;
    private final List<String> listOfSubjects;
    private final Map<String, Integer> marks;
}

class Technician extends Employee {
    Technician(int age, double weight, double height, Date dateOfBirth,
            String address, double salary, Date dateOfJoining, int experience) {
        super(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Professor extends Employee {
    Professor(int age, double weight, double height, Date dateOfBirth, String address,
            double salary, Date dateOfJoining, int experience,
            List<String> courses, List<String> listOfAdvisee) {
        super(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);
        this.courses = courses;
        this.listOfAdvisee = listOfAdvisee;
    }

    List<String> getCourses() {
        return courses;
    }

    List<String> getListOfAdvisee() {
        return listOfAdvisee;
    }

    void addAdvisee(String advisee) {
        listOfAdvisee.add(advisee);
    }

    void removeAdvisee(String advisee) {
        listOfAdvisee.remove(advisee);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCourses = " + courses +
                "\nList Of Advisee = " + listOfAdvisee;
    }

    private final List<String> courses;
    private final List<String> listOfAdvisee;
}