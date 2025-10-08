
import java.util.Scanner;
public class A3 {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n1.Volume of Cylinder\n2.Factorial\n3.Armstrong\n4.Exit");
            System.out.print("Enter your choice:");  // ask user for choice
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter radius:");
                    double r = sc.nextDouble();
                    System.out.print("Enter height:");  // ask user for height of cylinder
                    double  h = sc.nextDouble();
                    System.out.println("Volume of cylinder=" + (Math.PI * r * r * h));
                    break;
                case 2:
                    System.out.print("Enter number:");
                    int n = sc.nextInt(), f = 1;
                    for (int i = 1; i <= n; i++) f *= i;
                    System.out.println("Factorial of " + n + "=" + f);
                    break;
                case 3:
                    System.out.print("Enter number:");
                    int num = sc.nextInt(), sum = 0, t = num, d, digits = 0;
                    for (int x = num; x > 0; x /= 10) digits++;
                    for (; t > 0; t /= 10) { d = t % 10; sum += Math.pow(d, digits); }
                    System.out.println(sum == num ? "Armstrong" : "Not Armstrong");
                    break;
                default:System.out.println("Bye");
            }
        } while (ch != 4);
    }
}

