import java.util.Scanner;
class SYMarks {
    int computerTotal, mathsTotal, electronicsTotal;
    SYMarks(int c, int m, int e) {
        computerTotal = c;
        mathsTotal = m;
        electronicsTotal = e;
    }
}
class TYMarks {
    int theory, practicals;
    TYMarks(int t, int p) {
        theory = t;
        practicals = p;
    }
}
class Student {
    int rollNumber;
    String name;
    SYMarks sy;
    TYMarks ty;
    Student(int roll, String nm, SYMarks syMarks, TYMarks tyMarks) {
        rollNumber = roll;
        name = nm;
        sy = syMarks;
        ty = tyMarks;
    }
    void displayResult() {
        int totalComputerMarks = sy.computerTotal + ty.theory + ty.practicals;
        String grade;
        if (totalComputerMarks >= 70) grade = "A";
        else if (totalComputerMarks >= 60) grade = "B";
        else if (totalComputerMarks >= 50) grade = "C";
        else if (totalComputerMarks >= 40) grade = "Pass Class";
        else grade = "FAIL";
        System.out.println("\nRoll No: " + rollNumber);
        System.out.println("Name   : " + name);
        System.out.println("SY Computer Marks : " + sy.computerTotal);
        System.out.println("TY Theory         : " + ty.theory);
        System.out.println("TY Practicals     : " + ty.practicals);
        System.out.println("Total Computer Marks: " + totalComputerMarks);
        System.out.println("Grade: " + grade);
    }
}
public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("SY Computer Marks: ");
            int syComp = sc.nextInt();
            System.out.print("SY Maths Marks: ");
            int syMaths = sc.nextInt();
            System.out.print("SY Electronics Marks: ");
            int syElect = sc.nextInt();
            System.out.print("TY Theory Marks: ");
            int tyTheory = sc.nextInt();
            System.out.print("TY Practicals Marks: ");
            int tyPract = sc.nextInt();
            SYMarks sy = new SYMarks(syComp, syMaths, syElect);
            TYMarks ty = new TYMarks(tyTheory, tyPract);
            students[i] = new Student(roll, name, sy, ty);
        }
        System.out.println("\n--- Student Results ---");
        for (Student s : students) {
            s.displayResult();
        }
    }
}