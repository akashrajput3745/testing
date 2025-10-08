import java.util.Scanner;
public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter full name (first middle last): ");
        String first = sc.next();
        String middle = sc.next();
        String last = sc.next();
        
        String middleFormatted = middle.substring(0, 1).toUpperCase() + middle.substring(1);        
        System.out.println("Formatted name: " + last + ", " + first + " " + middleFormatted);
        sc.close();
    }
}