
public class C3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 15; j++) {
                System.out.printf("%-9s", (j + "*" + i + "=" + (i * j)));
            }
            System.out.println();
        }
        System.out.println("Multiplication table from 0 to 10 and 0 to 15 is printed.");
    }
}
