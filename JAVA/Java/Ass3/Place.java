import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// Base class: Continent
class Continent {
    String continent;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    void inputContinent() throws IOException {
        System.out.print("Enter Continent Name: ");
        continent = br.readLine();
    }
}

// Derived class: Country (inherits Continent)
class Country extends Continent {
    String country;

    void inputCountry() throws IOException {
        System.out.print("Enter Country Name: ");
        country = br.readLine();
    }
}

// Derived class: State (inherits Country)
class State extends Country {
    String state;

    void inputState() throws IOException {
        System.out.print("Enter State Name: ");
        state = br.readLine();
    }
}

// Further derived class: Place (inherits State)
class Place extends State {
    String place;

    void inputPlace() throws IOException {
        System.out.print("Enter Place Name: ");
        place = br.readLine();
    }

    void displayAll() {
        System.out.println("Place: " + place);
        System.out.println("State: " + state);
        System.out.println("Country: " + country);
        System.out.println("Continent: " + continent);
    }

    public static void main(String[] args) throws IOException {
        Place p = new Place();
        p.inputContinent();
        p.inputCountry();
        p.inputState();
        p.inputPlace();
        p.displayAll();
    }
}