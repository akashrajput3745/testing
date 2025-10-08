import java.util.Scanner;

// User defined exception class
class NameInvalidException extends Exception {
    public NameInvalidException(String message) {
        super(message);
    }
}

public class c2 {

    // Method to validate the name
    public static void validateName(String name) throws NameInvalidException {
        // Regex to check if the string contains only alphabets (both uppercase and lowercase)
        if (!name.matches("[a-zA-Z]+")) {
            throw new NameInvalidException("Name is Invalid");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee name: ");
        String employeeName = scanner.nextLine();

        try {
            validateName(employeeName);
            System.out.println("Employee name is valid: " + employeeName);
        } catch (NameInvalidException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}