import java.io.*;
import java.util.Scanner;

class Book {
    String bookid;
    String bookname;
    double bookprice;
    int bookqty;

    Book(String bookid, String bookname, double bookprice, int bookqty) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.bookqty = bookqty;
    }
}

public class b1 {

    static final int RECORD_SIZE = 80; // Fixed size for each record in bytes

    // Method to write sample book data to file for testing
    static void writeSampleData() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("book.dat", "rw")) {
            raf.setLength(0); // clear file
            writeBook(raf, 0, new Book("B001", "Java Basics", 350.50, 10));
            writeBook(raf, 1, new Book("B002", "Python Guide", 420.75, 5));
            writeBook(raf, 2, new Book("B003", "C Programming", 299.99, 7));
        }
    }

    // Write a book record at recordNumber in the file
    static void writeBook(RandomAccessFile raf, int recordNumber, Book book) throws IOException {
        raf.seek(recordNumber * RECORD_SIZE);
        // Write fixed length strings padded with spaces for bookid and bookname
        writeFixedString(raf, book.bookid, 10);
        writeFixedString(raf, book.bookname, 30);
        raf.writeDouble(book.bookprice);
        raf.writeInt(book.bookqty);
        // Padding to complete the record size
        long currentPos = raf.getFilePointer();
        int remaining = (int) (RECORD_SIZE - (currentPos - (recordNumber * RECORD_SIZE)));
        for (int i = 0; i < remaining; i++) {
            raf.writeByte(' ');
        }
    }

    // Read a book record at recordNumber from the file
    static Book readBook(RandomAccessFile raf, int recordNumber) throws IOException {
        raf.seek(recordNumber * RECORD_SIZE);
        String bookid = readFixedString(raf, 10).trim();
        String bookname = readFixedString(raf, 30).trim();
        double bookprice = raf.readDouble();
        int bookqty = raf.readInt();
        return new Book(bookid, bookname, bookprice, bookqty);
    }

    // Write fixed length string padded with spaces
    static void writeFixedString(RandomAccessFile raf, String s, int length) throws IOException {
        int i;
        for (i = 0; i < s.length() && i < length; i++) {
            raf.writeChar(s.charAt(i));
        }
        for (; i < length; i++) {
            raf.writeChar(' ');
        }
    }

    // Read fixed length string of given length
    static String readFixedString(RandomAccessFile raf, int length) throws IOException {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(raf.readChar());
        }
        return sb.toString();
    }

    // Get number of records in the file
    static int getNumberOfRecords(RandomAccessFile raf) throws IOException {
        return (int) (raf.length() / RECORD_SIZE);
    }

    // Search book by name
    static void searchBookByName(String searchName) {
        try (RandomAccessFile raf = new RandomAccessFile("book.dat", "r")) {
            int numRecords = getNumberOfRecords(raf);
            boolean found = false;
            for (int i = 0; i < numRecords; i++) {
                Book book = readBook(raf, i);
                if (book.bookname.equalsIgnoreCase(searchName)) {
                    System.out.println("Book found:");
                    printBook(book);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book with name '" + searchName + "' not found.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display all books and total cost
    static void displayAllBooks() {
        try (RandomAccessFile raf = new RandomAccessFile("book.dat", "r")) {
            int numRecords = getNumberOfRecords(raf);
            double totalCost = 0;
            System.out.println("BookID\tBookName\t\tPrice\tQuantity\tCost");
            System.out.println("----------------------------------------------------------------");
            for (int i = 0; i < numRecords; i++) {
                Book book = readBook(raf, i);
                printBookFormatted(book);
                totalCost += book.bookprice * book.bookqty;
            }
            System.out.println("----------------------------------------------------------------");
            System.out.printf("Total cost of all books: %.2f", totalCost);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void printBook(Book book) {
        System.out.println("BookID: " + book.bookid);
        System.out.println("BookName: " + book.bookname);
        System.out.println("Price: " + book.bookprice);
        System.out.println("Quantity: " + book.bookqty);
        System.out.println("Cost: " + (book.bookprice * book.bookqty));
    }

    static void printBookFormatted(Book book) {
        System.out.printf("%-8s\t%-15s\t%.2f\t%d\t\t%.2f", book.bookid, book.bookname, book.bookprice, book.bookqty,(book.bookprice * book.bookqty));
    }

    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            writeSampleData(); // Write sample book data for demo purpose

            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Search Book by Name");
                System.out.println("2. Display All Books and Total Cost");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter book name to search: ");
                        String name = sc.nextLine();
                        searchBookByName(name);
                    }
                    case 2 -> displayAllBooks();
                    case 3 -> System.out.println("Exiting program.");
                    default -> System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 3);
        }
    }
}