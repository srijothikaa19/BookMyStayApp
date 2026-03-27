import java.util.*;

/**
 * CLASS: BookingHistory
 *
 * Stores confirmed reservations
 *
 * @version 8.0
 */
public class BookingHistory {

    // List of confirmed reservations
    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /**
     * Add reservation to history
     */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /**
     * Get all reservations
     */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}