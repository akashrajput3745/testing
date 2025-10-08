interface Operation {
    double PI = 3.142;    // Constant defined in interface
    
    double area();        // Abstract method
    double volume();      // Abstract method
}

class Cylinder implements Operation {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Area of Cylinder: 2 * PI * r * h + 2 * PI * r * r
    public double area() {
        return (2 * PI * radius * height) + (2 * PI * radius * radius);
    }

    // Volume of Cylinder: PI * r^2 * h
    public double volume() {
        return PI * radius * radius * height;
    }

    // Display results
    public void display() {
        System.out.printf("Area of Cylinder: %.3f", area());
        System.out.printf("Volume of Cylinder: %.3f", volume());
    }
}

public class a3 {
    public static void main(String[] args) {
        Cylinder c = new Cylinder(5, 10);  // Example: radius = 5, height = 10
        c.display();
    }
}