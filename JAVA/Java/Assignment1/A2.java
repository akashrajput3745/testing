
import java.util.Scanner;
public class A2 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        int length = sc.nextInt();
        System.out.print("Enter breadth: ");
        int breadth = sc.nextInt();
        float area = length*breadth;
        int perimeter = (2*(length*breadth));
        System.out.println("Area is :" +area);
        System.out.println("perimeter is :" +perimeter);    
    }
}