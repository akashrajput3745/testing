import java.util.Scanner;

// Abstract class Order
abstract class Order {
    int id;
    String description;

    abstract void accept(Scanner sc);
    abstract void display();
}

// Subclass PurchaseOrder
class PurchaseOrder extends Order {
    String customerName;

    void accept(Scanner sc) {
        System.out.print("Enter Purchase Order ID: ");
        id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Purchase Order Description: ");
        description = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
    }

    void display() {
        System.out.println("Purchase Order ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Customer Name: " + customerName);
        System.out.println();
    }
}

// Subclass SalesOrder
class SalesOrder extends Order {
    String vendorName;

    void accept(Scanner sc) {
        System.out.print("Enter Sales Order ID: ");
        id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Sales Order Description: ");
        description = sc.nextLine();
        System.out.print("Enter Vendor Name: ");
        vendorName = sc.nextLine();
    }

    void display() {
        System.out.println("Sales Order ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Vendor Name: " + vendorName);
        System.out.println();
    }
}

// Main class to test the functionality
public class b1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PurchaseOrder[] purchaseOrders = new PurchaseOrder[3];
        SalesOrder[] salesOrders = new SalesOrder[3];

        System.out.println("Enter details for 3 Purchase Orders:");
        for (int i = 0; i < 3; i++) {
            purchaseOrders[i] = new PurchaseOrder();
            purchaseOrders[i].accept(sc);
        }

        System.out.println("Enter details for 3 Sales Orders:");
        for (int i = 0; i < 3; i++) {
            salesOrders[i] = new SalesOrder();
            salesOrders[i].accept(sc);
        }

        System.out.println("Purchase Orders Details:");
        for (PurchaseOrder po : purchaseOrders) {
            po.display();
        }

        System.out.println("Sales Orders Details:");
        for (SalesOrder so : salesOrders) {
            so.display();
        }

        sc.close();
    }
}