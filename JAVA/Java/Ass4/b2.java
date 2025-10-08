// User-defined exception for invalid username
class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

// User-defined exception for invalid password
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class EmailId {
    String username;
    String password;

    // Default constructor
    public EmailId() {
        username = "";
        password = "";
    }

    // Parameterized constructor
    public EmailId(String username, String password) throws InvalidUsernameException, InvalidPasswordException {
        if (!isValidUsername(username)) {
            throw new InvalidUsernameException("Invalid Username: Username must be at least 5 characters.");
        }

        if (!isValidPassword(password)) {
            throw new InvalidPasswordException("Invalid Password: Password must be at least 8 characters.");
        }

        this.username = username;
        this.password = password;
    }

    // Simple username validation (at least 5 chars)
    private boolean isValidUsername(String username) {
        return username != null && username.length() >= 5;
    }

    // Simple password validation (at least 8 chars)
    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
}

public class b2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide username and password as command line arguments.");
            return;
        }

        String username = args[0];
        String password = args[1];

        try {
            EmailId email = new EmailId(username, password);
            System.out.println("EmailId object created successfully.");
            System.out.println("Username: " + email.username);
            System.out.println("Password: " + email.password);
        } catch (InvalidUsernameException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}