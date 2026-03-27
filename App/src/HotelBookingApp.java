public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Cancellation service
        CancellationService cancelService = new CancellationService();

        // Simulate confirmed booking (from UC6)
        String reservationId = "Single-1";
        String roomType = "Single";

        cancelService.registerBooking(reservationId, roomType);

        // Cancel booking
        cancelService.cancelBooking(reservationId, inventory);

        // Show rollback history
        cancelService.showRollbackHistory();

        // Show updated inventory
        int updated = inventory.getAvailability("Single");
        System.out.println("\nUpdated Single Room Availability: " + updated);
    }
}