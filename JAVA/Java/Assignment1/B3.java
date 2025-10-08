
import java.util.Scanner;
public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add\n2. Multiply\n3. Transpose\n4. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            if (ch == 4) break;
            System.out.print("Rows: ");
            int r = sc.nextInt();
            System.out.print("Cols: ");
            int c = sc.nextInt();
            int[][] A = new int[r][c];
            System.out.println("Enter Matrix:");
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    A[i][j] = sc.nextInt();

            if (ch == 1) {
                int[][] B = new int[r][c];
                System.out.println("Enter Second Matrix:");
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        B[i][j] = sc.nextInt();
                System.out.println("Sum:");
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++)
                        System.out.print((A[i][j] + B[i][j]) + " ");
                    System.out.println();
                }
            } else if (ch == 2) {
                System.out.print("Cols of second matrix: ");
                int c2 = sc.nextInt();
                int[][] B = new int[c][c2];
                System.out.println("Enter Second Matrix:");
                for (int i = 0; i < c; i++)
                    for (int j = 0; j < c2; j++)
                        B[i][j] = sc.nextInt();
                int[][] res = new int[r][c2];
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c2; j++)
                        for (int k = 0; k < c; k++)
                            res[i][j] += A[i][k] * B[k][j];
                System.out.println("Product:");
                for (int[] row : res) {
                    for (int val : row)
                        System.out.print(val + " ");
                    System.out.println();
                }
            } else if (ch == 3) {
                System.out.println("Transpose:");
                for (int i = 0; i < c; i++) {
                    for (int j = 0; j < r; j++)
                        System.out.print(A[j][i] + " ");
                    System.out.println();
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}