/**
 * CLASS: BookingReportService
 *
 * Generates reports from booking history
 *
 * @version 8.0
 */
public class BookingReportService {

    /**
     * Generate booking report
     */
    public void generateReport(BookingHistory history) {

        System.out.println("Booking History Report\n");

        for (Reservation r : history.getConfirmedReservations()) {
            System.out.println(
                    "Guest: " + r.getGuestName() +
                            ", Room Type: " + r.getRoomType()
            );
        }
    }
}