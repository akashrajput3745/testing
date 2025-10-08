import java.util.Scanner;

// User-defined exception class
class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

// MyDate class with validation
class MyDate {
    private int day, month, year;

    public void accept(int d, int m, int y) throws InvalidDateException {
        if (!isValidDate(d, m, y)) {
            throw new InvalidDateException("Invalid Date: " + d + "/" + m + "/" + y);
        }
        day = d;
        month = m;
        year = y;
    }

    public void display() {
        System.out.println("Date is valid: " + day + "/" + month + "/" + year);
    }

    // Date validation method
    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12)
            return false;

        if (day < 1)
            return false;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return day <= 31;
            case 4: case 6: case 9: case 11:
                return day <= 30;
            case 2:
                if (isLeapYear(year))
                    return day <= 29;
                else
                    return day <= 28;
            default:
                return false;
        }
    }

    // Leap year check
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

// Main class to test the MyDate and exception
public class b3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date as dd mm yyyy:");

        try {
            int dd = scanner.nextInt();
            int mm = scanner.nextInt();
            int yyyy = scanner.nextInt();

            MyDate date = new MyDate();
            date.accept(dd, mm, yyyy);
            date.display();
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}