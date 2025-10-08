
import java.util.*;
public class C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of countries: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] countries = new String[n];
        System.out.println("Enter country names:");
        for (int i = 0; i < n; i++) {
            countries[i] = sc.nextLine();
        }

        Arrays.sort(countries, Collections.reverseOrder());

        System.out.println("\nCountries in descending order:");
        for (String country : countries) {
            System.out.println(country);
        }
    }
}