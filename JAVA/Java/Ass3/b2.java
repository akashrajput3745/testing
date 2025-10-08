// Marker interface
interface ProductMarker {
    // empty marker interface
}

// Product class implementing marker interface
class Product implements ProductMarker {
    int product_id;
    String product_name;
    double product_cost;
    int product_quantity;
    static int objectCount = 0; // static count of objects

    // Default constructor
    public Product() {
        this.product_id = 0;
        this.product_name = "Default";
        this.product_cost = 0.0;
        this.product_quantity = 0;
        objectCount++;
    }

    // Parameterized constructor
    public Product(int product_id, String product_name, double product_cost, int product_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_cost = product_cost;
        this.product_quantity = product_quantity;
        objectCount++;
    }

    // Method to display product details
    public void display() {
        System.out.println("Product ID: " + product_id);
        System.out.println("Product Name: " + product_name);
        System.out.println("Product Cost: " + product_cost);
        System.out.println("Product Quantity: " + product_quantity);
        System.out.println("------------------------");
    }

    // Static method to display object count
    public static void displayObjectCount() {
        System.out.println("Total Product Objects Created: " + objectCount);
    }
}

public class b2 {
    public static void main(String[] args) {
        // Creating product objects
        Product p1 = new Product(); // default constructor
        Product p2 = new Product(101, "Laptop", 75000.50, 5);
        Product p3 = new Product(102, "Smartphone", 32000.00, 10);

        // Display product details
        p1.display();
        p2.display();
        p3.display();

        // Display total object count
        Product.displayObjectCount();
    }
}