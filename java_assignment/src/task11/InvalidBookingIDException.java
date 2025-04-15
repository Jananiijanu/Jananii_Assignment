package task11;


public class InvalidBookingIDException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidBookingIDException(String message) {
        super(message);
    }
}