public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection\n");

        // Assume this came from UC6 allocation
        String reservationId = "Single-1";

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService spa = new AddOnService("Spa", 1000.0);

        // Service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Attach services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        // Calculate total
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        // Output
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}