import java.util.Scanner;

// Abstract class Staff
abstract class Staff {
    protected int id;
    protected String name;

    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract method to display details
    public abstract void display();
}

// Subclass OfficeStaff
class OfficeStaff extends Staff {
    private String department;

    public OfficeStaff(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    // Override display method
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("----------------------");
    }
}

// Main class
public class a2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of OfficeStaff: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        OfficeStaff[] staffArr = new OfficeStaff[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            staffArr[i] = new OfficeStaff(id, name, dept);
        }

        System.out.println("All OfficeStaff Details:");
        for (OfficeStaff staff : staffArr) {
            staff.display();
        }

        sc.close();
    }
}