import java.io.*;
import java.util.*;

public class c1 {
    static ArrayList<Integer> numbers = new ArrayList<>();

    // Method to generate 10 random two-digit numbers
    public static void loadNumbers() {
        numbers.clear();
        Random rand = new Random();
        System.out.println("Loading 10 random two-digit numbers:");
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(90) + 10; // generates between 10 and 99
            numbers.add(num);
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Method to save numbers to a file
    public static void saveNumbers() {
        if (numbers.isEmpty()) {
            System.out.println("No numbers to save. Please load numbers first.");
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("number.txt"))) {
            for (int num : numbers) {
                writer.println(num);
            }
            System.out.println("Numbers saved to file 'number.txt'.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }

    // Method to display numbers
    public static void displayNumbers() {
        if (numbers.isEmpty()) {
            System.out.println("No numbers loaded. Please load numbers first.");
            return;
        }
        System.out.println("Current numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Load 10 random two-digit integers");
            System.out.println("2. Save numbers to file");
            System.out.println("3. Display numbers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    loadNumbers();
                    break;
                case 2:
                    saveNumbers();
                    break;
                case 3:
                    displayNumbers();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
        } while (choice != 4);

        sc.close();
    }
}