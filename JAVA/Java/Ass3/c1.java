import java.util.ArrayList;
import java.util.Scanner;

// Department Interface
interface Department {
    String deptName = null;
    String deptHead = null;

    void printDeptName();
    void printDeptHead();
}

// Hostel Class
class Hostel {
    String hostelName;
    String hostelLocation;
    int numberOfRooms;

    public Hostel() {}

    public Hostel(String hostelName, String hostelLocation, int numberOfRooms) {
        this.hostelName = hostelName;
        this.hostelLocation = hostelLocation;
        this.numberOfRooms = numberOfRooms;
    }

    void printHostelInfo() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Hostel Location: " + hostelLocation);
        System.out.println("Number Of Rooms: " + numberOfRooms);
    }
}

// Student Class
class Student extends Hostel implements Department {
    String studentName;
    String regNo;
    String electiveSubject;
    double avgMarks;

    String deptName;  // implement deptName from Department interface
    String deptHead;  // implement deptHead from Department interface

    public Student() {}

    public Student(String hostelName, String hostelLocation, int numberOfRooms,
                   String studentName, String regNo, String electiveSubject, double avgMarks,
                   String deptName, String deptHead) {
        super(hostelName, hostelLocation, numberOfRooms);
        this.studentName = studentName;
        this.regNo = regNo;
        this.electiveSubject = electiveSubject;
        this.avgMarks = avgMarks;
        this.deptName = deptName;
        this.deptHead = deptHead;
    }

    // Implement abstract methods of Department interface
    public void printDeptName() {
        System.out.println("Department Name: " + deptName);
    }

    public void printDeptHead() {
        System.out.println("Department Head: " + deptHead);
    }

    // printData method
    void printData() {
        System.out.println("--- Student Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Registration Number: " + regNo);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks: " + avgMarks);
        printDeptName();
        printDeptHead();
        printHostelInfo();
    }
}

// Driver class
public class c1 {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Method to admit new student
    static void admitNewStudent() {
        System.out.print("Enter Hostel Name: ");
        String hName = scanner.nextLine();
        System.out.print("Enter Hostel Location: ");
        String hLocation = scanner.nextLine();
        System.out.print("Enter Number Of Rooms in Hostel: ");
        int noRooms = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Student Name: ");
        String sName = scanner.nextLine();
        System.out.print("Enter Registration Number: ");
        String regNo = scanner.nextLine();
        System.out.print("Enter Elective Subject: ");
        String elective = scanner.nextLine();
        System.out.print("Enter Average Marks: ");
        double avgMarks = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Department Name: ");
        String dName = scanner.nextLine();
        System.out.print("Enter Department Head: ");
        String dHead = scanner.nextLine();

        Student newStudent = new Student(hName, hLocation, noRooms, sName, regNo, elective, avgMarks, dName, dHead);
        students.add(newStudent);
        System.out.println("Student admitted successfully.");
    }

    // Method to migrate a student (update details)
    static void migrateStudent() {
        System.out.print("Enter Registration Number of student to migrate: ");
        String regNo = scanner.nextLine();
        Student foundStudent = null;
        for (Student s : students) {
            if (s.regNo.equals(regNo)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("Student with Registration Number " + regNo + " not found.");
            return;
        }

        System.out.println("Enter updated details for migration:");
        System.out.print("Enter New Hostel Name: ");
        foundStudent.hostelName = scanner.nextLine();
        System.out.print("Enter New Hostel Location: ");
        foundStudent.hostelLocation = scanner.nextLine();
        System.out.print("Enter New Number Of Rooms: ");
        foundStudent.numberOfRooms = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter New Department Name: ");
        foundStudent.deptName = scanner.nextLine();
        System.out.print("Enter New Department Head: ");
        foundStudent.deptHead = scanner.nextLine();

        System.out.println("Student migration details updated successfully.");
    }

    // Method to display student details by regNo
    static void displayStudent() {
        System.out.print("Enter Registration Number of student to display: ");
        String regNo = scanner.nextLine();

        Student foundStudent = null;
        for (Student s : students) {
            if (s.regNo.equals(regNo)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("Student with Registration Number " + regNo + " not found.");
            return;
        }

        foundStudent.printData();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Admit new student");
            System.out.println("2. Migrate a student");
            System.out.println("3. Display details of a student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    admitNewStudent();
                    break;
                case 2:
                    migrateStudent();
                    break;
                case 3:
                    displayStudent();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
    }
}