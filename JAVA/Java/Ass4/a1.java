// User-defined exception class
class CovidPositiveException extends Exception {
    public CovidPositiveException(String message) {
        super(message);
    }
}

// Patient class with attributes and constructor
class Patient {
    String patient_name;
    int patient_age;
    int patient_oxy_level;
    int patient_HRCT_report;

    Patient(String name, int age, int oxy_level, int HRCT_report) {
        this.patient_name = name;
        this.patient_age = age;
        this.patient_oxy_level = oxy_level;
        this.patient_HRCT_report = HRCT_report;
    }

    // Method to display patient details
    void displayInfo() {
        System.out.println("Patient Name: " + patient_name);
        System.out.println("Patient Age: " + patient_age);
        System.out.println("Patient Oxygen Level: " + patient_oxy_level);
        System.out.println("Patient HRCT Report: " + patient_HRCT_report);
    }
}

public class a1 { 
    public static void main(String[] args) {
        // Create a patient object
        Patient p = new Patient("John Doe", 40, 92, 12);

        try {
            // Check condition and throw exception if needed
            if (p.patient_oxy_level < 95 && p.patient_HRCT_report > 10) {
                throw new CovidPositiveException("Patient is Covid Positive(+) and Need to Hospitalized");
            } else {
                p.displayInfo();
            }
        } catch (CovidPositiveException e) {
            System.out.println(e.getMessage());
        }
    }
}