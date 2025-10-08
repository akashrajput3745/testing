
import java.util.Scanner;
public class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        int choice;
        do {
            System.out.println("\n1. Sum of Diagonal");
            System.out.println("2. Sum of Upper Diagonal");
            System.out.println("3. Sum of Lower Diagonal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int sum = 0;
            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++)
                        sum += mat[i][i];
                    System.out.println("Sum of diagonal elements: " + sum);
                    break;
                case 2:
                    for (int i = 0; i < n; i++)
                        for (int j = i + 1; j < n; j++)
                            sum += mat[i][j];
                    System.out.println("Sum of upper diagonal elements: " + sum);
                    break;
                case 3:
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < i; j++)
                            sum += mat[i][j];
                    System.out.println("Sum of lower diagonal elements: " + sum);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        sc.close();
    }
}
