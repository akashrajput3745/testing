package Java.Assignment1;
public class MyNumber {
    private int x;
    public MyNumber() {
        x = 0;
    }
    public MyNumber(int x) {
        this.x = x;
    }
    public boolean isNegative() {
        return x < 0;
    }
    public boolean isPositive() {
        return x > 0;
    }
    public boolean isZero() {
        return x == 0;
    }
    public boolean isOdd() {
        return x % 2 != 0;
    }
    public boolean isEven() {
        return x % 2 == 0;
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }
        int value = Integer.parseInt(args[0]);
        MyNumber num = new MyNumber(value);
        if (num.isNegative()) System.out.println("Number is Negative");
        if (num.isPositive()) System.out.println("Number is Positive");
        if (num.isZero())     System.out.println("Number is Zero");
        if (num.isOdd())      System.out.println("Number is Odd");
        if (num.isEven())     System.out.println("Number is Even");
    }
}