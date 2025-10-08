class Customer {
    public String publicName = "Public Name";
    private String privateEmail = "private@email.com";
    protected String protectedPhone = "9876543210";
    String defaultCity = "Pune"; 

    void showFromCustomer() {
        System.out.println("Inside Customer class:");
        System.out.println("Public: " + publicName);
        System.out.println("Private: " + privateEmail);
        System.out.println("Protected: " + protectedPhone);
        System.out.println("Default: " + defaultCity);
    }
}
class SamePackageAccess {
    void showFromSamePackage() {
        Customer c = new Customer();
        System.out.println("\nAccess from SamePackageAccess class:");
        System.out.println("Public: " + c.publicName);
          System.out.println("Protected: " + c.protectedPhone);
        System.out.println("Default: " + c.defaultCity);
    }
}
class DifferentPackageAccess extends Customer {
    void showFromDifferentPackage() {
        System.out.println("\nAccess from DifferentPackageAccess class (simulating different package):");
        System.out.println("Public: " + publicName);
         System.out.println("Protected (via inheritance): " + protectedPhone);
    }
}
public class C2 {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.showFromCustomer();

        SamePackageAccess spa = new SamePackageAccess();
        spa.showFromSamePackage();

        DifferentPackageAccess dpa = new DifferentPackageAccess();
        dpa.showFromDifferentPackage();
    }
}
