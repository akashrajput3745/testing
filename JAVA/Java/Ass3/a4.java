// Define a functional interface
@FunctionalInterface
interface Cube {
    int calculate(int number);
}

public class a4 {
    public static void main(String[] args) {
        // Lambda expression implementing the Cube interface
        Cube cube = (number) -> number * number * number;

        int num = 5;
        int result = cube.calculate(num);

        System.out.println("Cube of " + num + " is: " + result);
    }
}