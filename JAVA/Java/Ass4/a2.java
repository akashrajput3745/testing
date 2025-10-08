import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class a2 {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Original Contents in Upper Case:");
            while ((line = br.readLine()) != null) {
                // Display line in uppercase
                System.out.println(line.toUpperCase());
                // Append to content for reversing later
                content.append(line).append("");
            }

            // Remove the last newline character for accurate reverse
            if (content.length() > 0) {
                content.deleteCharAt(content.length() - 1);
            }

            // Reverse the entire content character-wise
            content.reverse();

            System.out.println("Contents in Reverse Order:");
            System.out.println(content.toString());

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}