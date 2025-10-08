import java.util.*;
class Student {
    int roll_no;
    String name;
    double percentage;
    Student(int roll_no, String name, double percentage) {
        this.roll_no = roll_no;
        this.name = name;
        this.percentage = percentage;
    }
    public static void sortStudent(Student[] students) {
        Arrays.sort(students, Comparator.comparingDouble(s -> s.percentage));
    }
    public void display() {
        System.out.println("Roll No: " + roll_no + ", Name: " + name + ", Percentage: " + percentage);
    }
}
public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int roll_no = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Percentage: ");
            double percentage = sc.nextDouble();

            students[i] = new Student(roll_no, name, percentage);
        }

        Student.sortStudent(students);

        System.out.println("\nStudents sorted by percentage:");
        for (Student s : students) {
            s.display();
        }

        sc.close();
    }
}
