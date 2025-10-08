
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class B1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (dd/MM/yyyy): ");
        String input = sc.nextLine();
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        System.out.println("Current date is  : " + new SimpleDateFormat("dd/MM/yyyy").format(now));
        System.out.println("Current date is  : " + new SimpleDateFormat("MM-dd-yyyy").format(now));
        System.out.println("Current date is  : " + new SimpleDateFormat("EEEE MMMM dd yyyy").format(now));
        System.out.println("Current date and time is  : " + new SimpleDateFormat("E MMMM dd HH:mm:ss z yyyy").format(now));
        System.out.println("Current date and time is  : " + new SimpleDateFormat("dd/MM/yy HH:mm:ss a Z").format(now));
        System.out.println("Current time is  : " + new SimpleDateFormat("HH:mm:ss").format(now));
        System.out.println("Current week of year is : " + cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Current week of month : " + cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Current day of the year is : " + cal.get(Calendar.DAY_OF_YEAR));
    }
}