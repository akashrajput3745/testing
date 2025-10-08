import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class a3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter source file name: ");
            String sourceFile = sc.nextLine();
            System.out.print("Enter destination file name: ");
            String destinationFile = sc.nextLine();

            FileReader fin = new FileReader(sourceFile);
            FileWriter fout = new FileWriter(destinationFile);

            int c;
            // Copy contents from the first file to the second file
            while ((c = fin.read()) != -1) {
                fout.write(c);
            }
            // Add comment at the end of the second file
            fout.write("end of file");

            System.out.println("File copied successfully with comment added.");

            fin.close();
            fout.close();
        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}