package Java.Assignment2;
    class Employee {
    
    int id;
    String name;
    String deptName;
    double salary;
   
    static int count = 0;
   
    Employee() {
        this.id = 0;
        this.name = "Unknown";
        this.deptName = "None";
        this.salary = 0.0;
        count++;
        displayCount();
        displayDetails();
    }
    
    Employee(int id, String name, String deptName, double salary) {
        this.id = id;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
        count++;
        displayCount();
        displayDetails();
    }
    
    static void displayCount() {
        System.out.println("🧮 Total Employees Created: " + count);
    }
    
    void displayDetails() {
        System.out.println("📋 Employee Details:");
        System.out.println("ID       : " + this.id);
        System.out.println("Name     : " + this.name);
        System.out.println("Dept     : " + this.deptName);
        System.out.println("Salary   : ₹" + this.salary);
        System.out.println("---------------------------");
    }
    
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Chandrashekhar", "Development", 75000);
        Employee e2 = new Employee(102, "Sneha", "Design", 68000);
        Employee e3 = new Employee(103, "Rahul", "Testing", 62000);
    }
}

