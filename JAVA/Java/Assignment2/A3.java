import java.util.Arrays;
public class A3 {
        public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Please enter exactly 5 numbers as command-line arguments.");
            return;
        }
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + args[i] + " is not a valid number.");
                return;
            }
        }
        Arrays.sort(numbers);
        
        System.out.println("Sorted numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
