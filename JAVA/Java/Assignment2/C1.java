
import java.util.Scanner;

class Con {
    void concatenate(String s1, String s2) {
        String result = s1 + s2;
        System.out.println("Concatenated String: " + result);
    }
}

class Comp {
    void compare(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }
    }
}

public class C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        Con conObj = new Con();
        Comp compObj = new Comp();

        System.out.println("\n--- String Operations ---");
        conObj.concatenate(str1, str2);
        compObj.compare(str1, str2);
    }
}