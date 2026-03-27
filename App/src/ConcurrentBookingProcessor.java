/**
 * CLASS: ConcurrentBookingProcessor
 *
 * Handles booking in multi-threaded environment
 *
 * @version 11.0
 */

public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔒 Critical section: retrieving from queue
            synchronized (bookingQueue) {

                if (!bookingQueue.hasPendingRequests()) {
                    break;
                }

                reservation = bookingQueue.getNextRequest();
            }

            // 🔒 Critical section: allocation + inventory update
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}