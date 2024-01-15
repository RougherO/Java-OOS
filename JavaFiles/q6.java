import java.util.List;
import java.util.ArrayList;

public class q6 {
    public static void main(String[] args) {
        Dept itDept = new Dept("Information Technology", "Headquarters");

        itDept.addEmployee(new Employee("John Doe", 101, "123 Main St", 60000));
        itDept.addEmployee(new Employee("Jane Smith", 102, "456 Oak St", 70000));
        itDept.addEmployee(new Employee("Bob Johnson", 103, "789 Pine St", 80000));
        itDept.addEmployee(new Employee("Alice Williams", 104, "101 Maple St", 90000));
        itDept.addEmployee(new Employee("Charlie Brown", 105, "202 Birch St", 100000));

        System.out.println("Dept:\n" + itDept);
        System.out.println();
        System.out.println("Yearly Expenditure: $" + itDept.calculateYearlyExpenditure());
    }
}

class Employee {
    private String name;
    private int id;
    private String address;
    private double salary;

    public Employee(String name, int id, String address, double salary) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nName = " + name +
                "\nID = " + id +
                "\nAddress = " + address +
                "\nSalary = $" + salary;
    }
}

class Dept {
    private String name;
    private String location;
    private List<Employee> employees;

    public Dept(String name, String location) {
        this.name = name;
        this.location = location;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public double calculateYearlyExpenditure() {
        double yearlyExpenditure = 0;
        for (Employee employee : employees) {
            yearlyExpenditure += employee.getSalary();
        }
        return yearlyExpenditure;
    }

    @Override
    public String toString() {
        return "Name = " + name +
                "\nLocation = " + location +
                "\n\nEmployees:" +
                String.join("\n", employees.stream().map((employee) -> String.valueOf(employee)).toList());
    }
}
