public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Allocation service
        RoomAllocationService allocationService = new RoomAllocationService();

        // Process queue (FIFO)
        while (queue.hasPendingRequests()) {
            Reservation request = queue.getNextRequest();
            allocationService.allocateRoom(request, inventory);
        }
    }
}