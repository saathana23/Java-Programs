public class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Permanent employee
    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Intern
    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        EmployeeProfile e1 =
            new EmployeeProfile("E-101", "Divya", 65000);

        EmployeeProfile e2 =
            new EmployeeProfile("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}