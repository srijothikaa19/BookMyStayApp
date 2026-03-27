/**
 * Custom exception for invalid bookings
 *
 * @version 9.0
 */
public class InvalidBookingException extends Exception {

    public InvalidBookingException(String message) {
        super(message);
    }
}